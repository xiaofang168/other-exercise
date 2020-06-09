package com.fangj.exercise.comfuture;

import com.alibaba.fastjson.JSON;
import jodd.io.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author fangjie
 * @date Created in 4:17 下午 2020/6/9.
 */
public class CollectCollege {

    private static ExecutorService executorService = new ThreadPoolExecutor(200, 500,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(2000), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        File f = new File("/Users/fangjie/college");
        String[] list = f.list();
        List<CompletableFuture<List<College>>> completableFutureList = new ArrayList<>();
        for (String file : list) {
            String filePath = f + "/" + file;
            CompletableFuture<List<College>> completableFuture = readFile(filePath);
            completableFutureList.add(completableFuture);
        }
        CompletableFuture<List<College>>[] array = completableFutureList.toArray(new CompletableFuture[0]);
        // 阻塞直到所有线程执行完成
        CompletableFuture.allOf(array).join();
        // 取值
        List<List<College>> collect = Arrays.stream(array).map(CompletableFuture::join).collect(Collectors.toList());
        List<College> result = collect.stream()
                .filter(e -> e.size() != 0)
                .flatMap(List::stream)
                .sorted(Comparator.comparingLong(College::getId))
                .collect(Collectors.toList());
        System.out.println(result.size());
        System.out.println("cost:" + (System.currentTimeMillis() - start));
        FileUtil.writeString(new File("/Users/fangjie/sdaxue_college.json"), JSON.toJSONString(result));
        executorService.shutdown();
    }

    private static CompletableFuture<List<College>> readFile(String file) {
        CompletableFuture<List<College>> completableFuture = CompletableFuture.supplyAsync(() -> {
            String json = null;
            try {
                json = FileUtil.readString(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            List<College> list = JSON.parseArray(json, College.class);
            return list;
        }, executorService);
        return completableFuture;
    }

}

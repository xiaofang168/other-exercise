package com.fangj.exercise.io;

/**
 * @author jefffang
 * @date Created in 10:41 上午 2021/11/26.
 */
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.*;

public class RandomAccessFileLogView {
    /**
     *  上次文件大小
     */
    private long lastTimeFileSize = 0;

    /**
     * 实时输出日志信息
     * @param logFile 日志文件
     * @throws IOException
     */
    public void realtimeShowLog(File logFile) throws Exception{
        // 指定文件可读可写
        final RandomAccessFile randomFile = new RandomAccessFile(logFile,"rw");
        // 启动一个线程每10秒钟读取新增的日志信息
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
        exec.scheduleWithFixedDelay(() -> {
            try {
                // 获得变化部分的,游标定位
                randomFile.seek(lastTimeFileSize);
                String tmp = "";
                while( (tmp = randomFile.readLine())!= null) {
                    System.out.println(tmp);
                }
                lastTimeFileSize = randomFile.length();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, 0, 1, TimeUnit.SECONDS);
        // 等待未完成任务结束
        if(!exec.awaitTermination(2, TimeUnit.SECONDS)) {
            // 取消当前执行的任务
            exec.shutdownNow();
        }
    }

    public static void main(String[] args) throws Exception {
        RandomAccessFileLogView view = new RandomAccessFileLogView();
        final File tmpLogFile = new File(RandomAccessFileLogView.class.getResource("gc_read.log").getPath());
        view.realtimeShowLog(tmpLogFile);
    }

}

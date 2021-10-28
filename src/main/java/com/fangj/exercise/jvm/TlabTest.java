package com.fangj.exercise.jvm;

import java.time.Instant;

/**
 * 栈上分配，依赖于逃逸分析和标量替换
 * <pre>
 *     https://www.helloworld.net/p/9240235907
 *     -server -Xmx15m -Xms15m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-UseTLAB -XX:+EliminateAllocations
 *     // 不使用逃逸分析
 *    -server -Xmx15m -Xms15m -XX:+PrintGCDetails -XX:-UseTLAB -XX:-DoEscapeAnalysis -XX:+EliminateAllocations
 *     // 不使用标量替换
 *   -server -Xmx15m -Xms15m -XX:+PrintGCDetails -XX:-UseTLAB -XX:+DoEscapeAnalysis -XX:-EliminateAllocations
 * </pre>
 *
 * @author fangjie
 * @date Created in 9:54 上午 2021/10/27.
 */
public class TlabTest {
    // private static User u;

    /**
     * 一个User对象的大小：markdown 8 + class pointer 4 + int 4 + string (oops) 4 + padding 4 = 24B <br> 如果分配 100_000_000 个，则需要
     * 2400_000_000 字节， 约 2.24 GB。
     */
    static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    private static void alloc() {
        User u = new User(1, "SvenAugustus");
    }

    public static void main(String[] args) throws InterruptedException {
        long start = Instant.now().toEpochMilli();
        for (int i = 0; i < 100_000_000; i++) {
            alloc();
        }
        System.out.println(Instant.now().toEpochMilli() - start);
    }

}

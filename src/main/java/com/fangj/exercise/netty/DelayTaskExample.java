package com.fangj.exercise.netty;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * 时间轮算法的插入删除时间复杂度是O(1)
 * Timer 、ScheduledThreadPool 和 DelayQueue，总结的说下它们都是通过优先队列来获取最早需要执行的任务，
 * 因此插入和删除任务的时间复杂度都为O(logn)，并且 Timer 、ScheduledThreadPool 的周期性任务是通过重置任务的下一次执行时间来完成的。
 *
 * @author jefffang
 * @date Created in 11:27 上午 2022/5/31.
 */
public class DelayTaskExample {

    public static void main(String[] args) {
        System.out.println("程序启动时间：" + LocalDateTime.now());
        NettyTask();
    }

    /**
     * 基于 Netty 的延迟任务
     */
    private static void NettyTask() {
        // 创建延迟任务实例
        HashedWheelTimer timer = new HashedWheelTimer(3,
                TimeUnit.SECONDS,
                100);
        // 创建一个任务
        TimerTask task = new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("执行任务" +
                        " ，执行时间：" + LocalDateTime.now());
            }
        };
        // 将任务添加到延迟队列中
        timer.newTimeout(task, 0, TimeUnit.SECONDS);
    }

}

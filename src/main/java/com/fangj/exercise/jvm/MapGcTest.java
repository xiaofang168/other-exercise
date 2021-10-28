package com.fangj.exercise.jvm;

import java.util.HashMap;
import java.util.Map;

/**
 * 验证map remove后老年代对象是否还在，答案是还在，只能等gc清理
 * <pre>
 * -verbose:gc
 * -Xmx200M
 * -Xms200M
 * -Xmn50M
 * -XX:TargetSurvivorRatio=60
 * -XX:+UseConcMarkSweepGC
 * -XX:+UseParNewGC
 * -XX:MaxTenuringThreshold=3
 * -XX:+PrintGCDetails
 * -XX:+PrintGCDateStamps
 * -XX:+PrintGCTimeStamps
 * -XX:+PrintHeapAtGC
 * -XX:+PrintTenuringDistribution
 * -XX:+PrintGCCause
 * -XX:+PrintAdaptiveSizePolicy
 * -XX:+PrintPromotionFailure
 * -XX:+UnlockDiagnosticVMOptions
 * -XX:+TraceGCTaskThread
 * </pre>
 *
 * @author fangjie
 * @date Created in 7:24 下午 2021/10/27.
 */
public class MapGcTest {
    private static final Map map = new HashMap();

    public static void main(String[] args) throws InterruptedException {
        // 4m
        map.put("a", new byte[1 * 2 * 1024 * 1024]);
        map.put("b", new byte[1 * 2 * 1024 * 1024]);
        youngGc(1);
        Thread.sleep(10000);
        //System.gc();
        youngGc(1);
        map.remove("a");
        Thread.sleep(10000);
        map.remove("b");
        //System.gc();
        Thread.sleep(10000);
        // System.gc();
        //System.gc();
    }

    private static void youngGc(int ygcTimes) {
        for (int i = 0; i < ygcTimes * 50; i++) {
            // 1M共40M
            byte[] byte1m = new byte[1 * 1024 * 1024];
        }
    }

}

package com.fangj.exercise.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 默认垃圾回收器采用多线程回收会在老年代产生8k数据，单线程不会
 * <pre>
 * -Xms256m
 * -Xmx256m
 * -Xmn128m
 * -Xss512k
 * -XX:-UseAdaptiveSizePolicy
 * -XX:TargetSurvivorRatio=80
 * -XX:MetaspaceSize=256m
 * -XX:MaxMetaspaceSize=256m
 * -XX:ParallelGCThreads=4
 * -XX:MaxTenuringThreshold=15
 * -XX:OldPLABSize=0k
 * -XX:-ResizePLAB
 * -XX:-ResizeOldPLAB
 * -verbose:gc
 * -XX:+PrintGCDetails
 * -XX:+PrintGCDateStamps
 * -XX:+PrintGCTimeStamps
 * -XX:+PrintHeapAtGC
 * -XX:+PrintTenuringDistribution
 * -XX:+PrintGCApplicationConcurrentTime
 * -XX:+PrintGCApplicationStoppedTime
 * -XX:+PrintGCCause
 * -XX:+PrintAdaptiveSizePolicy
 * -XX:+PrintPromotionFailure
 * -XX:+UnlockDiagnosticVMOptions
 * -XX:+PrintCodeCache
 * -XX:+PrintTLAB
 * -XX:+PrintOldPLAB
 * -XX:+TraceGCTaskThread
 * </pre>
 *
 * @author fangjie
 * @date Created in 6:32 下午 2021/10/25.
 */
public class GcRunTest {

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            //Thread.sleep(1);
            List list = new ArrayList<>();
            User test = new User();
            test.setAddr("ddd");
            test.setSex(1);
            list.add(test);
        }
    }

}

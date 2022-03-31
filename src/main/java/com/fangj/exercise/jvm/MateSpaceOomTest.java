package com.fangj.exercise.jvm;

/**
 * 元空间oom模拟
 * 如果碰到经常Full GC的情况，但是老年代空间使用的却不多，年轻代GC后的情况也很正常，
 * 同时也不存在突然大对象的情况，但是元空间却一直递增，那么可以考虑下是不是使用了反射等手段导致元空间加载的类太多了，导致元空间爆满触发Full GC，
 * 那么此时就可以加上-XX:+TraceClassLoading和-XX:+TraceClassUnloading这两个参数，看下类加载和卸载的情况，
 * 确定下是不是有哪些类反复被生成和加载，找到相应的类，然后跟踪到代码里，排除问题
 * <pre>
 * -Xms512M
 * -Xmx512M
 * -Xmn128M
 * -XX:MetaspaceSize=28m
 * -XX:MaxMetaspaceSize=28m
 * -XX:+TraceClassLoading
 * -XX:+TraceClassUnloading
 * -XX:MaxTenuringThreshold=15
 * -XX:SurvivorRatio=6
 * -XX:-UseAdaptiveSizePolicy
 * -XX:ParallelGCThreads=1
 * -verbose:gc
 * -XX:+PrintGCDetails
 * -XX:+PrintHeapAtGC
 * -XX:+PrintGCDateStamps
 * -XX:+PrintGCTimeStamps
 * -XX:+PrintPromotionFailure
 * -XX:+PrintTenuringDistribution
 * </pre>
 *
 * @author fangjie
 * @date Created in 7:24 下午 2021/10/27.
 */
public class MateSpaceOomTest {

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread.sleep(1);
            MyClassLoader myClassLoader = new MyClassLoader();
            // 带package的类path
            myClassLoader.findClass("com.test.SplitHandleWithRegex");
            myClassLoader.getParent();
        }
    }

}

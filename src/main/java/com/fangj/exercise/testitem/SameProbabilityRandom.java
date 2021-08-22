package com.fangj.exercise.testitem;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * n(Rn-1)+Rn，新函数中靠近后面的最小公倍数舍弃
 *
 * @author fangjie
 * @date Created in 下午1:08 2021/8/22.
 */
public class SameProbabilityRandom {

    private static int callRand5Count = 0;

    public static int rand3() {
        int[] nums = new int[]{1, 2, 3};
        Random random = new Random();
        int index = random.nextInt(nums.length);
        // 概率相等模拟
        return nums[index];
    }

    /**
     * n(Rn-1)+Rn
     * 靠近5的倍数舍弃
     *
     * @return
     */
    public static int rand5() {
        callRand5Count++;
        int value;
        do {
            // 原函数元素的个数，前后两个函数相加所得结果(1,2,3,4,5,6...)，采用坐标列举出(1,3)(2,2)-像这种就重复了，只有一种可能(概率相等)
            value = 3 * (rand3() - 1) + rand3();
        } while (value > 10);
        // 作用于新的函数的靠近后面的最小倍数,修改value的条件即可
        value = value % 5 + 1;
        return value;
    }

    public static void main(String[] args) {
        int value1 = 1;
        int value2 = 2;
        int value3 = 3;
        int value4 = 4;
        AtomicInteger value1Count = new AtomicInteger();
        AtomicInteger value2Count = new AtomicInteger();
        AtomicInteger value3Count = new AtomicInteger();
        AtomicInteger value4Count = new AtomicInteger();
        AtomicInteger value5Count = new AtomicInteger();
        IntStream.range(0, 100).forEach(e -> {
            int rand5 = rand5();
            if (rand5 == value1) {
                value1Count.incrementAndGet();
            } else if (rand5 == value2) {
                value2Count.incrementAndGet();
            } else if (rand5 == value3) {
                value3Count.incrementAndGet();
            } else if (rand5 == value4) {
                value4Count.incrementAndGet();
            } else {
                value5Count.incrementAndGet();
            }
        });
        System.out.println(value1Count.intValue() + ">>" + value2Count.intValue() + ">>" + value3Count.intValue() + ">>" + value4Count.intValue() + ">>" + value5Count.intValue());
        System.out.println(value1Count.floatValue() / callRand5Count + ">>" + value2Count.floatValue() / callRand5Count + ">>" + value3Count.floatValue() / callRand5Count + ">>"
                + value4Count.floatValue() / callRand5Count + ">>" + value5Count.floatValue() / callRand5Count);
    }

}

package com.fangj.exercise.algorithm;

/**
 * 异或算法找出不重复出现的数字(数组要有序)
 * 查找数组中只有1个或2个不重复的元素
 * 首先将数字转换成二进制
 * 进行异或运算（异或运算法则是相同部位相同取0否则取1）
 *
 * @author fangjie
 * @date Created in 5:53 PM 2019/2/20.
 */
public class Yihuo {
    public static void main(String[] args) {
        System.out.println("唯一的数字是：" + singleNumber(new int[]{1, 4, 4, 108, 1, 4, 1, 4, 200, 200}));
        System.out.println("相同数异或操作：" + (8 ^ 8));
        System.out.println("不通数异或操作：" + (8 ^ 7 ^ 8));
    }

    public static int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

}

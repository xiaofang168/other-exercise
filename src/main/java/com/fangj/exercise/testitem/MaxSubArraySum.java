package com.fangj.exercise.testitem;

/**
 * 最大子列表和
 *
 * @author jefffang
 * @date Created in 7:26 下午 2022/7/25.
 */
public class MaxSubArraySum {

    public static void main(String[] args) {
        // 连续子数组 [4,-1,2,1] 的和最大，为 6
        int value = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println("\n");
        System.out.println(value);
    }

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            if (pre + x > 0) {
                System.out.println(x);
            }
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

}

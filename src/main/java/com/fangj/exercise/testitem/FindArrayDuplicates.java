package com.fangj.exercise.testitem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 偏移量映射
 *
 * @author jefffang
 * @date Created in 5:07 下午 2022/7/26.
 */
public class FindArrayDuplicates {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> res = find(nums);
        for (Integer val : res) {
            System.out.println(val);
        }
    }

    public static List<Integer> find(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            // 已经修改过
            if (nums[num % 10000 - 1] > 10000) {
                res.add(num % 10000);
            } else {
                nums[num % 10000 - 1] += 10000;
            }
            System.out.println(Arrays.toString(nums));
        }
        return res;
    }

}

package com.fangj.exercise.testitem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组其中2个元素相加等于第3个元素(排序+2层循环配合首位指针)
 *
 * @author fangjie
 * @date Created in 下午7:55 2021/8/18.
 */
public class Array2plusEq1By2Point {

    public static List<Integer[]> find(int[] nums) {
        List<Integer[]> result = new ArrayList<>();
        // nums排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int head = i + 1;
            int tail = nums.length - 1;
            for (int m = head; m < nums.length; m++) {
                if (head == tail) {
                    break;
                }
                if (nums[head] + nums[tail] == -nums[i]) {
                    result.add(new Integer[]{nums[i], nums[head], nums[tail]});
                    break;
                } else if (nums[head] + nums[tail] < (-nums[i])) {
                    head++;
                } else {
                    // 移动尾指针
                    tail--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<Integer[]> result = find(nums);
        if (result.isEmpty()) {
            System.out.println("[]");
        } else {
            result.forEach(e ->
                    System.out.println(Arrays.toString(e))
            );
        }
    }

}

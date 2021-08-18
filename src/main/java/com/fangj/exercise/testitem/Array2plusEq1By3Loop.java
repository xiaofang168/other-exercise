package com.fangj.exercise.testitem;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组其中2个元素相加等于第3个元素(排序+3层循环实现)
 *
 * @author fangjie
 * @date Created in 下午7:55 2021/8/18.
 */
public class Array2plusEq1By3Loop {

    public static List<Integer[]> find(int[] nums) {
        List<Integer[]> result = new ArrayList<>();
        int index = 0;
        // nums排序
        Arrays.sort(nums);
        // 相同数的标记
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            // 相同的只算一次
            if (first == flag) {
                continue;
            }
            flag = first;
            for (int m = i + 1; m < nums.length; m++) {
                int second = nums[m];
                for (int n = m + 1; n < nums.length; n++) {
                    int third = nums[n];
                    if (first + second + third == 0) {
                        index = index + 1;
                        result.add(new Integer[]{first, second, third});
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4, 7};
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

package com.fangj.exercise.testitem;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author fangjie
 * @date Created in 下午4:25 2021/9/6.
 */
public class ArrayLargeNum {

    public static String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = Integer.toString(nums[i]);
        }

        System.out.println("排序前" + Arrays.toString(strs));

        /*
        这里有一个小技巧：假设只有两个数字，如何确定哪个数字在前面？
        设 a = 203; b = 2，有 a + b = 2032；b + a = 2203，显然 (b + a) > (a + b)，此时应该把 b 放在前面
         */
        Arrays.sort(strs, (o1, o2) -> {
            int compareTo = (o2 + o1).compareTo(o1 + o2);
            if (compareTo > 0) {
                // 降序
                return 1;
            } else if (compareTo < 0) {
                // 升序
                return -1;
            }
            return 0;
        });

        System.out.println("2203".compareTo("2032"));
        System.out.println("排序后" + Arrays.toString(strs));

        // 有一个全是 0.
        if (Objects.equals("0", strs[0])) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (String val : strs) {
            ret.append(val);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String s = largestNumber(new int[]{1, 3, 20, 0, 5});
        System.out.println(s);
    }

}

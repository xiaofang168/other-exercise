package com.fangj.exercise.testitem;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复的最长子串
 *
 * @author jefffang
 * @date Created in 5:11 下午 2022/7/28.
 */
public class LongestSubStr {

    public static void main(String[] args) {
        String s = "pwwkew";
        int res = find(s);
        System.out.println(res);
    }

    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    private static int find(String s) {
        int len = s.length(), ans = 0;
        // 字符和位置(滑动)
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < len; end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

}

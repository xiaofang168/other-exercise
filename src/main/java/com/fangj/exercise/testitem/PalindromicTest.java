package com.fangj.exercise.testitem;

/**
 * @author jefffang
 * @date Created in 3:56 下午 2022/7/27.
 */
public class PalindromicTest {
    public static void main(String[] args) {
        String s = "abaad";
        String ans = longestPalindrome(s);
        System.out.println(ans);
    }

    private static String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String a = s.substring(i, j);
                if (isPalindromic(a) && a.length() > max) {
                    ans = a;
                    max = Math.max(max, ans.length());
                }
            }
        }
        return ans;
    }

    private static boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

}

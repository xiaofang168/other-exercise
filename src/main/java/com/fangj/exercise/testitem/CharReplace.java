package com.fangj.exercise.testitem;

/**
 * @author fangjie
 * @date Created in 下午9:19 2021/8/17.
 */
public class CharReplace {

    public static String replace(String s, String c) {
        char[] originC = s.toCharArray();
        char[] descC = c.toCharArray();
        int m = 0;
        for (int i = 0; i < originC.length; i++) {
            if (m < descC.length && originC[i] == descC[m]) {
                m++;
            } else {
                m = 0;
            }
            // 找到匹配的字符
            if (m == descC.length) {
                // 回溯移除
                for (int j = 0; j < descC.length; j++) {
                    originC[i--] = '0';
                }
                // 跳出循环
                break;
            }
        }
        String s1 = String.valueOf(originC);
        // 如果包含继续迭代
        if (s1.contains(c)) {
            return replace(s1, c);
        }
        // 去掉空字符
        StringBuilder sb = new StringBuilder();
        for (char c1 : originC) {
            if (c1 != '0') {
                sb.append(c1);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = replace("abcdefdf", "de");
        System.out.println(s);
    }

}

package com.fangj.exercise.testitem;

/**
 * @author fangjie
 * @date Created in 下午4:39 2021/8/12.
 */
public class FindNum {

    public static int find(int[] arr, int x) {
        int j = -1;
        if (arr[arr.length - 1] >= x) {
            return arr.length - 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1 && arr[i] >= x && arr[i + 1] < x) {
                j = i;
            }
            if (arr[i + 1] < x) {
                break;
            }
        }
        return j;
    }

    /**
     * X=7，返回第三个7对应下标4
     * <p>
     * 元素：9 8 7 7 7 6 5 5 3 2
     * <p>
     * 下标：0 1 2 3 4 5 6 7 8 9
     * <p>
     * <p>
     * X=4，返回第二个5对应的下标7
     * <p>
     * 元素：9 8 7 7 7 6 5 5 3 2
     * <p>
     * 下标：0 1 2 3 4 5 6 7 8 9
     * <p>
     * <p>
     * X=1，返回2对应下标9
     * <p>
     * 元素：9 8 7 7 7 6 5 5 3 2
     * <p>
     * 下标：0 1 2 3 4 5 6 7 8 9
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 7, 7, 6, 5, 5, 3, 2};
        int[] x = {7, 4, 1, 10};
        for (int s : x) {
            System.out.println("X=" + s + " ans=" + find(arr, s));
        }
    }

}

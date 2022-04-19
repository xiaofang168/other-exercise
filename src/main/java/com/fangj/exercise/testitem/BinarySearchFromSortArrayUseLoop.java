package com.fangj.exercise.testitem;

/**
 * @author fangjie
 * @date Created in 下午9:29 2022/4/19.
 */
public class BinarySearchFromSortArrayUseLoop {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        int indexNum = search(array, 5);
        System.out.println("循环查找索引结果>>>" + indexNum);
    }

    public static int search(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println("low:" + low + " mid:" + mid);
            int midVal = arr[mid];
            if (num > midVal) {
                low = mid + 1;
            } else if (num < midVal) {
                high = mid - 1;
            } else if (midVal == num) {
                return mid;
            }
        }
        return -1;
    }

}

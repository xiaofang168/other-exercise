package com.fangj.exercise.testitem;

/**
 * @author fangjie
 * @date Created in 下午9:29 2022/4/19.
 */
public class BinarySearchFromSortArrayUseMyLoop {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
                18, 20, 25, 27, 30, 31, 32, 35, 57, 63, 81, 84, 101, 102, 108, 200, 202, 301};
        for (int i = 0; i < array.length; i++) {
            int indexNum = search(array, array[i]);
            System.out.println("循环查找" + array[i] + "索引结果>>>" + indexNum);
        }
        System.out.println("\n查找不存在的...\n");
        int[] notFoundArray = {0, 19, 26, 29, 33, 82, 85, 107, 303, 302, 399, 408, 409};
        for (int i : notFoundArray) {
            int indexNum = search(array, i);
            System.out.println("循环查找" + i + "索引结果>>>" + indexNum);
        }
        System.out.println("====end====");
    }

    public static int search(int[] array, int dest) {
        if (array == null) {
            return -1;
        }
        int cursorIndex = array.length / 2;
        int middleValue;
        // 右侧区间遍历
        if (dest > array[cursorIndex]) {
            int c = 0;
            while (true) {
                middleValue = array[cursorIndex];
                // 右区间指针
                if (dest > middleValue) {
                    // 往右走的距离
                    c = (array.length - cursorIndex) / 2;
                    cursorIndex = cursorIndex + c;
                    if (c == 0 && dest > array[cursorIndex]) {
                        return -1;
                    }
                } else if (dest < middleValue) {
                    // 往左回修正
                    c = c / 2 == 0 ? 1 : c / 2;
                    cursorIndex = cursorIndex - c;
                    if (c == 1 && dest > array[cursorIndex]) {
                        return -1;
                    }
                }
                if (dest == array[cursorIndex]) {
                    return cursorIndex;
                }
            }
        } else if (dest < array[cursorIndex]) {
            int c = 0;
            // 左侧区间遍历
            while (true) {
                middleValue = array[cursorIndex];
                // 左区间指针
                if (dest < middleValue) {
                    // 往右走的距离
                    c = cursorIndex / 2;
                    cursorIndex = cursorIndex / 2;
                    if (c == 0 && dest < array[cursorIndex]) {
                        return -1;
                    }
                } else if (dest > middleValue) {
                    // 少加一点
                    c = c / 2 == 0 ? 1 : c / 2;
                    cursorIndex = cursorIndex + c;
                    if (c == 1 && dest < array[cursorIndex]) {
                        return -1;
                    }
                }
                if (dest == array[cursorIndex]) {
                    return cursorIndex;
                }
            }
        }
        return cursorIndex;
    }

}

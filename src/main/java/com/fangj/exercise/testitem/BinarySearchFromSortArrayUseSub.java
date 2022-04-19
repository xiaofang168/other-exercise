package com.fangj.exercise.testitem;


import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * @author fangjie
 * @date Created in 4:45 下午 2022/4/19.
 */
public class BinarySearchFromSortArrayUseSub {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 10, 11};
        int indexNum = search(array, 2, 0, array.length / 2);
        System.out.println("二分查找索引结果>>>" + indexNum);
    }

    /**
     * @param array    数组
     * @param dest     目标值
     * @param f        左右移动符号(-1左移动,1右移动)
     * @param indexNum 索引数字
     * @return
     */
    public static int search(int[] array, int dest, int f, int indexNum) {
        // 记录中间索引
        int middleIndex = array.length / 2;
        // 中间的数
        int middleValue = array[middleIndex];
        System.out.println(f + ">>" + Arrays.toString(array) + "，查找" + dest + "中间索引：" + middleIndex);
        // -控制左移动
        if (f == -1) {
            // 前推要减去剩下的
            indexNum = indexNum - (array.length - middleIndex);
        } else if (f == 1) {
            indexNum = indexNum + middleIndex;
        }
        // 分左右
        if (dest < middleValue) {
            int[] subarray = ArrayUtils.subarray(array, 0, middleIndex);
            return search(subarray, dest, -1, indexNum);
        } else if (dest > middleValue) {
            int[] subarray = ArrayUtils.subarray(array, middleIndex, array.length);
            return search(subarray, dest, 1, indexNum);
        }
        return indexNum;
    }

}

package com.zeroq6.java.algorithm.sort;

import com.zeroq6.java.algorithm.sort.utils.SortUtils;


/**
 * 选择排序
 * <p>
 * 循环n-1次，每次将最小值的下标记录下来，
 * 然后将这个下标记录的值添加到已排序列表的最后（已排序列表是给定数组前面的若干个位置，初始为0）
 * <p>
 * 时间复杂度O（N^2）
 */
public class SelectSort {

    public int[] selectSort(int[] ints) {
        int minPos = 0;
        int tmp = 0;
        // 循环n-1次即可，因为循环n-1次之后，前面n-1个是已经排序好的最小数，最后一个一定是最大
        for (int i = 0; i < ints.length - 1; i++) {
            // i代表已排序数的最后位置，初始为0
            // minPos表示位置i或之后最小值位置
            minPos = i;
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[minPos] > ints[j]) {
                    minPos = j;
                }
            }
            tmp = ints[minPos];
            ints[minPos] = ints[i];
            ints[i] = tmp;
        }
        return ints;


    }

    public static void main(String[] args) {
        SortUtils.print(new SelectSort().selectSort(SortUtils.getRandomIntArray(10, 100)));
    }


}

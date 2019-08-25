package com.zeroq6.java.algorithm.sort;

import com.zeroq6.java.algorithm.sort.utils.SortUtils;


/**
 * 插入排序
 * <p>
 * 将每次待排序数插入已排序列表中正确位置
 * <p>
 * 时间复杂度N^2
 */
public class InsertSort {

    public int[] insertSort(int[] ints) {
        int tmp = 0;
        // 第0个位置为有序，从1开始
        for (int i = 1; i < ints.length; i++) {
            int pos = i;
            // 从当前位置往前查找，若小于前面相邻有序数组则交换，直到不小于，此时前面有序数组加入了i位置数，并且有序
            while (pos > 0 && ints[pos] < ints[pos - 1]) {
                tmp = ints[pos];
                ints[pos] = ints[pos - 1];
                ints[pos - 1] = tmp;
                pos--;
            }
        }
        return ints;

    }


    public static void main(String[] args) {
        SortUtils.print(new InsertSort().insertSort(SortUtils.getRandomIntArray()));
    }

}

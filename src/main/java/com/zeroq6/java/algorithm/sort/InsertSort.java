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
        // 第0个位置为有序，从1开始
        for (int i = 1; i < ints.length; i++) {
            // 将要插入的位置
            int pos = i;
            int value = ints[pos];
            // 从当前位置往前查找，若大于当前位置值则后移动一位（相当于前面的值赋值给后面，然后前面的位置变成将要插入的位置），
            // 移动一位后，将要插入的位置前移一位（减1）
            while (pos > 0 && ints[pos - 1] > value) {
                ints[pos] = ints[pos - 1];
                pos--;
            }
            ints[pos] = value;
        }
        return ints;

    }


    public static void main(String[] args) {
        SortUtils.print(new InsertSort().insertSort(SortUtils.getRandomIntArray()));
    }

}

package com.zeroq6.java.algorithm.sort;


import com.zeroq6.java.algorithm.sort.utils.SortUtils;

/**
 * 计数排序
 * <p>
 * 记录每个数字出现的次数，打印出来
 * <p>
 * 记录的位置就是这个数字本身
 * 由于位置就是有序的，打印出次数不为0的位置即排序完成
 *
 * <p>
 * 时间复杂度M+N
 * 空间复杂度M
 * M为计数器的个数，N为待排序个数
 * <p>
 * http://blog.51cto.com/ahalei/1362789
 */
public class CountSort {

    public int[] countSort(int[] ints) {
        // 查找最大最小值，用于初始化计数的大小
        int max, min;
        max = min = ints[0];
        for (int i = 1; i < ints.length; i++) {
            if (min > ints[i]) {
                min = ints[i];
            }
            if (max < ints[i]) {
                max = ints[i];
            }
        }


        // 初始化排序范围
        int[] count = new int[max - min + 1];
        for (int i = 0; i < ints.length; i++) {
            // 记录每个数（ints[i]）出现的次数
            // 计数数组的位置比int[i]的值少min
            count[ints[i] - min]++;
        }
        int pos = 0;
        for (int i = 0; i < count.length; i++) {
            // 出现次数为0，说明没有出现i这个数
            if (count[i] == 0) {
                continue;
            }
            for (int j = 0; j < count[i]; j++) {
                // 计数数组的位置比int[i]的值少min，所以还原回去需要加上min
                ints[pos++] = i + min;
            }
        }
        return ints;

    }


    public static void main(String[] args) {
        SortUtils.print(new CountSort().countSort(SortUtils.getRandomIntArray()));
    }


}

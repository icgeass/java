package com.zeroq6.java.algorithm.sort;


import com.zeroq6.java.algorithm.sort.utils.SortUtils;

/**
 * 桶排序
 * <p>
 * 记录每个数字出现的次数，打印出来
 * <p>
 * 记录的位置就是这个数字本身
 * 由于位置就是有序的，打印出次数不为0的位置即排序完成
 *
 * <p>
 *     时间复杂度M+N
 *     空间复杂度M+N
 *     M为桶的个数，N为待排序个数
 * <p>
 * http://blog.51cto.com/ahalei/1362789
 */
public class BucketSort {

    private final static int MAX_INT = 100;

    public int[] bucketSort(int[] ints) {
        // 排序范围0到100
        int[] bucket = new int[MAX_INT + 1];
        for (int i = 0; i < ints.length; i++) {
            // 记录每个数（ints[i]）出现的次数
            bucket[ints[i]]++;
        }
        int[] result = new int[ints.length];
        int pos = 0;
        for (int i = 0; i < bucket.length; i++) {
            // 出现次数为0，说明没有出现i这个数
            if (bucket[i] == 0) {
                continue;
            }
            for (int j = 0; j < bucket[i]; j++) {
                result[pos++] = i;
            }
        }
        return result;

    }


    public static void main(String[] args) {
        SortUtils.print(new BucketSort().bucketSort(SortUtils.getRandomIntArray(10, MAX_INT)));
    }


}

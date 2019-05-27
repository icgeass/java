package com.zeroq6.java.learn.algorithm.sort;


/**
 * 桶排序
 * <p>
 * 空间复杂度M+1+N+1，O（M+N）
 * 时间复杂度M+N+M+N，O（M+N）
 * M为桶的个数，N为待排序个数
 * <p>
 * http://blog.51cto.com/ahalei/1362789
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] tong = new int[11]; // 排序范围为0~10，需要11个位置；M次
        int[] arr = new int[]{5, 3, 5, 2, 8};
        for (int i = 0; i < arr.length; i++) {// N次
            tong[arr[i]]++;
        }
        // 从大到小
        for (int i = tong.length - 1; i >= 0; i--) { // M次
            if (tong[i] != 0) {
                for (int j = 0; j < tong[i]; j++) {
                    System.out.print(i + " "); // N次
                }
            }
        }
        System.out.println();

    }


}

package com.zeroq6.java.algorithm.sort;


/**
 * 冒泡排序
 * <p>
 * 空间O（N）
 * 时间O（N^2）
 * <p>
 * http://blog.51cto.com/ahalei/1364401
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int tmp = 0;
        for (int i = 0; i < arr.length - 1; i++) { // 内层循环的次数，每一次内层循环都会将一个数放到排序好的位置，循环N-1次数就可以了，因为N-1个数如果都排序好了，那么N个数都排序好了
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] <= arr[j]) { // 每次找出小的，排到后面
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
        System.out.println();

    }
}

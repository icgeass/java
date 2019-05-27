package com.zeroq6.java.learn.algorithm.sort;


/**
 * 快速排序
 * <p>
 * 归位
 * 从右开始
 * 与相同的数相等，可以放左边（认为小），也可以放后边（认为大）
 * <p>
 * 空间复杂度：N
 * 时间复杂度：N*logN
 * <p>
 * http://blog.51cto.com/ahalei/1365285
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        quickSort(0, arr.length - 1, arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    private static void quickSort(int left, int right, int[] arr) {
        int i = left;
        int j = right;
        int tmp;
        if (i >= j) {
            return;
        }
        while (i != j) {
            while (j > i && arr[j] > arr[left]) { // 先移动右边，因为j=i时要和交换基准数，此时j指向的要交换的数要小于（或等于）基准数
                j--;
            }
            while (j > i && arr[i] <= arr[left]) { // 等于left的放左边
                i++;
            }
            if (i < j) { // 将i指向的大于基准数的数和j指向的小于等于基准数的数交换
                tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }

        // 交换基准数
        tmp = arr[left];
        arr[left] = arr[j];
        arr[j] = tmp;

        quickSort(left, i - 1, arr);
        quickSort(i + 1, right, arr);

    }
}


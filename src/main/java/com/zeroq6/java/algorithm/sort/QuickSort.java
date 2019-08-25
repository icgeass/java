package com.zeroq6.java.algorithm.sort;


import com.zeroq6.java.algorithm.sort.utils.SortUtils;

/**
 * 快速排序
 * <p>
 * 选定一个基准数（假定是最左边），比基准数小或者等于的放左边（左向右扫描），比基准数大的放右边（右向左扫描）
 * <p>
 * 最后交换基准数和左向右于右向左相遇的位置
 *
 * <p>
 * 空间复杂度：O（1）
 * 时间复杂度：O（N*logN）
 * <p>
 * http://blog.51cto.com/ahalei/1365285
 */
public class QuickSort {


    public int[] quickSort(int[] ints) {
        quickSort(0, ints.length - 1, ints);
        return ints;

    }

    /**
     * 每次选取最左边的数为基准数
     *
     * @param left  需要排序的数组左边位置
     * @param right 需要排序的数组右边位置
     * @param ints
     */
    private void quickSort(int left, int right, int[] ints) {
        int i = left;
        int j = right;
        int tmp = 0;
        if (left >= right) {
            return;
        }
        while (i != j) {
            // 右-->左，直到位置j的数小于等于基准数
            // 基准数在最左边，先从右往左扫描，保证每次i=j时与基准数交换的都是比基准数小的数
            while (i < j && ints[j] > ints[left]) {
                j--;
            }
            // 左-->右，直到位置i的数大于基准数
            // <=表明小于等于基准数的数都放在基准数左边
            while (i < j && ints[i] <= ints[left]) {
                i++;
            }
            // i=j时，是同一个数，没必要交换
            if (i < j) {
                // 此时i指向的数比基准数大，j指向的数比基准数小或等于，交换二者，使i能继续右移，j能继续左移，直到两者相遇，
                // 相遇表明该位置左边比基准数小于等于，右边比基准数大，
                // 而该位置的数比基准数小于或等于，需要和基准数交换（因为先右-->左，保证了相遇位置的数一定小于或等于基准数）
                tmp = ints[i];
                ints[i] = ints[j];
                ints[j] = tmp;
            }
        }
        // 交换基准数，这样基准数位置已经定位（归位），排序被基准数拆分的两个子数组
        tmp = ints[j];
        ints[j] = ints[left];
        ints[left] = tmp;
        // 排序剩下
        quickSort(left, i - 1, ints);
        quickSort(i + 1, right, ints);

    }

    public static void main(String[] args) {

        SortUtils.print(new QuickSort().quickSort(SortUtils.getRandomIntArray()));
    }
}


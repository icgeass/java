package com.zeroq6.java.algorithm.sort;

import com.zeroq6.java.algorithm.sort.utils.SortUtils;


/**
 * 归并排序，类似将两个有序数组合并为一个有序数组
 *
 *
 * 时间复杂度NlogN怎么算的
 */
public class MergeSort {


    public int[] mergeSort(int[] ints) {
        int len = ints.length;
        split(ints, new int[len], 0, len - 1);
        return ints;
    }

    /**
     * 拆分数组，合并数组
     *
     * @param ints  原始数组
     * @param tmp   中间临时数组，传递数组避免多次new操作
     * @param left  左子数组开始下标
     * @param right 右子数组结束下标
     */
    private void split(int[] ints, int[] tmp, int left, int right) {
        /**
         * left一定小于等于right，因为mid=(left+right)/2，结果会减去余数（1或者0）
         * 当left等于right，说明子数组长度为1，已经是序，不需要再拆分了，可以直接返回给上次调用直接合并
         * 当left小于right则继续拆分
         * 1，left比right小1，则mid=(left+right)/2=left，拆分的两个子数组下标为left，left和right，right；两个子数组有序，合并
         * 2，left比right小2，则mid=(left+right)/2=left+1，拆分的两个子数组下标为left，left+1和right，right；
         *    左子数组进入1，拆分合并，最终排序。右子数组长度为1，有序，最终合并有序
         * 3，left比right小3，则mid=(left+right)/2=(left+left+3)/2=舍余(left+1.5)=left+1；
         *    拆分的两个子数组下标为left，left+1和left+2，right；
         *    左子数组进入1，右子数组进入1，最终子数组有序，然后合并
         * ...
         *
         * 推导结果：层层递归，最终都会被拆分到两个子数组长度都为1，即两个子数组均有序，合并，然后收敛结果
         */
        if (left < right) {
            int mid = (left + right) / 2;
            // 拆分左子数组 
            split(ints, tmp, left, mid);
            // 拆分右子数组 
            split(ints, tmp, mid + 1, right);
            /**
             * 现在左右数组均已有序，开始合并
             */
            // 左子数组 指针
            int i = left;
            // 右子数组 指针
            int j = mid + 1;
            // tmp数组下标指针
            int pos = left;
            while (i <= mid && j <= right) {
                tmp[pos++] = ints[i] <= ints[j] ? ints[i++] : ints[j++];
            }

            while (i <= mid) {
                tmp[pos++] = ints[i++];
            }
            while (j <= right) {
                tmp[pos++] = ints[j++];
            }
            // 将tmp数组left到right位置复制到ints对应位置
            for (int k = left; k <= right; k++) {
                ints[k] = tmp[k];
            }
        }

    }


    public static void main(String[] args) {
        SortUtils.print(new MergeSort().mergeSort(SortUtils.getRandomIntArray()));
    }


}

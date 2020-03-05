package com.zeroq6.java.algorithm.sort;


import com.zeroq6.java.algorithm.sort.utils.SortUtils;

/**
 * 如果是小数或者负数可以转为非负整数，然后排序好了再转回去即可
 * <p>
 * 思路：
 * 先排低位，再排高位，没有高位则为0排到最小的桶表示最小；
 * 若有高位则按低位无效以高位为准
 * 如果高位相同，由于复制回原数组按放入桶的顺序，低位已经有序，依次逆推，可得知数字已经有序
 * <p>
 * 时间复杂度N*K ??
 * 空间复杂度N+K ??
 * <p>
 */
public class RadixSort {


    /**
     * @param ints
     * @return
     */
    public int[] radixSort(int[] ints) {
        // 10个桶
        int[][] bucket = new int[10][ints.length];
        // 每个桶的数字个数
        int[] bucketPos = new int[bucket.length];

        // 每次比较，数组中数字除以被除数devide后是否有大于0的数，
        // 有则说明需要进行下次排序，否则说明排序完成break
        boolean greaterZero = true;

        // 被除数
        int divide = 1;

        while (greaterZero) {
            greaterZero = false;
            // 用最末尾数字排序并放入桶中
            for (int i = 0; i < ints.length; i++) {
                // 暂存原数组中数字移位结果
                int digitInIntsMoved = ints[i] / divide;
                if (digitInIntsMoved != 0) {
                    greaterZero = true;
                }
                // 数字应该放到的桶的下标
                int index = digitInIntsMoved % 10;
                bucket[index][bucketPos[index]++] = ints[i];
            }
            if (!greaterZero) {
                break;
            }
            divide *= 10;
            // 复制回原数组时数组的数字的下标
            int intsCopyPos = 0;
            // 复制回原数组时每个桶中的数字的下标
            int digitPosInBucket = 0;
            // 同一个桶先放的一定是最小的，先取先放的数
            for (int i = 0; i < bucket.length; i++) {

                while (digitPosInBucket < bucketPos[i]) {
                    ints[intsCopyPos++] = bucket[i][digitPosInBucket++];
                }
                digitPosInBucket = 0;
                bucketPos[i] = 0;
            }
        }
        return ints;

    }

    public static void main(String[] args) {
        SortUtils.print(new RadixSort().radixSort(SortUtils.getRandomIntArray()));
    }


}
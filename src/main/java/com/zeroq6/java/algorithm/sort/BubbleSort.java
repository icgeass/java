package com.zeroq6.java.algorithm.sort;


import com.zeroq6.java.algorithm.sort.utils.SortUtils;

/**
 * 冒泡排序
 * <p>
 * 查找n-1次，每次将最大值放到最后，第一次将本次最大值放到最后一个位置，第二次将本次最大值放到倒数第二个位置 ...
 * 由于第n次比第一个位置大的n-1个数都放在最后了，所以不用再比较，即查找n-1次就可以了
 *
 * <p>
 * 空间O（1）
 * 时间O（N^2）
 * <p>
 * http://blog.51cto.com/ahalei/1364401
 */
public class BubbleSort {

    public int[] bubbleSort(int[] ints) {
        int tmp = 0;
        // 外层循环仅仅控制次数，和数字比较无关
        for (int i = 0; i < ints.length - 1; i++) {
            // 将ints[j]和ints[j+1]比较，如果j位置数大，则交换；
            // 此时j+1位置已经比j位置大了，再比较j+1位置和j+2位置，最终一次循环会本次最大的放到后面正确的位置
            // -i的原因是每执行一次循环就有一个数放到后面正确的位置，执行i次则后面有i个数已经排好了，不用再比较后面已排号的数
            // -1的原因是要比较j位置和下一个位置的数，循环范围只包含j位置即可，下一个位置用j+1计算，所以实际循环范围比所有本次要比较的数小1
            for (int j = 0; j < ints.length - i - 1; j++) {
                if (ints[j] > ints[j + 1]) {
                    tmp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = tmp;
                }
            }
        }
        return ints;

    }

    public static void main(String[] args) {
        SortUtils.print(new BubbleSort().bubbleSort(SortUtils.getRandomIntArray()));
    }
}

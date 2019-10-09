package com.zeroq6.java.leetcode.solution;


import com.zeroq6.java.leetcode.solution.help.ArrayHelper;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution42 {


    /**
     * 直观想法
     * <p>
     * 在暴力方法中，我们仅仅为了找到最大值每次都要向左和向右扫描一次。但是我们可以提前存储这个值。因此，可以通过动态编程解决。
     *
     * @param height
     * @return
     *
     *
     * 复杂性分析
     * 时间复杂度：O(n)
     *
     * 存储最大高度数组，需要两次遍历，每次 O(n)
     * 最终使用存储的数据更新，O(n)
     *
     * 空间复杂度：O(n) 额外空间。
     *
     *
     *
     */
    public int trap2(int[] height) {
        if (null == height || height.length < 3) {
            return 0;
        }
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = 0;
        rightMax[len - 1] = 0;
        for (int i = 1; i < len; i++) {
            leftMax[i] = height[i - 1] > leftMax[i - 1] ? height[i - 1] : leftMax[i - 1];
        }
        for (int i = len - 2; i > -1; i--) {
            rightMax[i] = height[i + 1] > rightMax[i + 1] ? height[i + 1] : rightMax[i + 1];
        }
        int sum = 0;
        for (int i = 1; i < len - 1; i++) {
            //
            int num = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (num > 0) {
                sum += num;
            }
        }
        return sum;
    }


    /**
     * 方法 1：暴力
     * 直观想法
     * <p>
     * 直接按问题描述进行。对于数组中的每个元素，我们找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
     * <p>
     * <p>
     * 复杂性分析
     * <p>
     * 时间复杂度： O(n^2)。数组中的每个元素都需要向左向右扫描。
     * <p>
     * 空间复杂度 O(1) 的额外空间。
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        // 方条数量小于等于2没法盛雨水
        if (null == height || height.length < 3) {
            return 0;
        }
        int sum = 0;
        // 第一个方条和最后一个方条没法盛雨水
        for (int i = 1; i < height.length - 1; i++) {
            // 找出左边最高
            int leftMax = 0;
            for (int j = 0; j < i; j++) {
                if (height[j] > leftMax) {
                    leftMax = height[j];
                }
            }
            // 当前
            int curr = height[i];
            // 找出右边最高
            int rightMax = 0;
            for (int k = i + 1; k < height.length; k++) {
                if (height[k] > rightMax) {
                    rightMax = height[k];
                }
            }
            int num = Math.min(leftMax, rightMax) - curr;
            if (num > 0) {
                sum += num;
            }
        }
        return sum;
    }


    // 无法解决大数据量问题
    public int trap0(int[] height) {
        int baseLine = 0;
        int maxHeight = -1;
        for (int i = 0; i < height.length; i++) {
            if (maxHeight < height[i]) {
                maxHeight = height[i];
            }
        }
        int sum = 0;
        final int indexNotSet = -1;
        // 每次加上空位，直到baseLine等于maxHeight
        while (baseLine < maxHeight) {
            boolean work = false;
            int indexBegin = indexNotSet;
            int indexEnd = indexNotSet;
            boolean baseLineFind = false;
            for (int i = 0; i < height.length; i++) {
                // 过滤小于等于baseLine
                if (!work && height[i] <= baseLine) {
                    continue;
                }
                work = true;
                // 设置开始位置
                if (indexBegin == indexNotSet) {
                    indexBegin = i;
                    continue;
                }
                // 设置发现空位
                if (height[i] <= baseLine) {
                    baseLineFind = true;
                    continue;
                }
                if (!baseLineFind) {
                    indexBegin = i; // 没有发现空位则开始下标后移
                } else {
                    indexEnd = i; // 发现空位则设置结束并添加雨量
                    sum += (indexEnd - indexBegin - 1);
                    // 重置
                    indexBegin = indexEnd; // 下一个空位的开始位置就是上一个空位结束的位置
                    indexEnd = indexNotSet;
                    baseLineFind = false;
                }

            }
            baseLine++;

        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution42().trap0(ArrayHelper.genIntArray(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)));
        System.out.println(new Solution42().trap1(ArrayHelper.genIntArray(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)));
        System.out.println(new Solution42().trap2(ArrayHelper.genIntArray(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)));
        System.out.println(new Solution42().trap2(ArrayHelper.genIntArray(2, 0, 2)));


    }
}

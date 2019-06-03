package com.zeroq6.java.leetcode.solution;


import com.zeroq6.java.leetcode.solution.help.ArrayHelper;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * <p>
 * <p>
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * <p>
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class Solution11 {

    public int maxArea(int[] height) {
        if (null == height || height.length < 2) {
            return 0;
        }
        int result = 0;
        int tmp = 0;
        int x = 0, y = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                x = height[i];
                y = height[j];
                tmp = (x < y ? x : y) * (j - i);
                result = result < tmp ? tmp : result;
            }
        }
        return result;


    }

    public static void main(String[] args) {
        System.out.println(new Solution11().maxArea(ArrayHelper.genIntArray(1,8,6,2,5,4,8,3,7)));
    }

}

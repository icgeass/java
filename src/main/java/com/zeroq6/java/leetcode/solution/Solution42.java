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
    public int trap(int[] height) {
        int baseLine = 0;
        int maxHeight = -1;
        for (int i = 0; i < height.length; i++) {
            if (maxHeight < height[i]) {
                maxHeight = height[i];
            }
        }
        int sum = 0;
        final int indexNotSet = -1;
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
                    indexBegin = indexEnd;
                    indexEnd = indexNotSet;
                    baseLineFind = false;
                }

            }
            baseLine++;

        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution42().trap(ArrayHelper.genIntArray(0,1,0,2,1,0,1,3,2,1,2,1)));
    }
}

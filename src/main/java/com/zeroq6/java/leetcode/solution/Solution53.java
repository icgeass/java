package com.zeroq6.java.leetcode.solution;


import com.zeroq6.java.leetcode.solution.help.ArrayHelper;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * <p>
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * <p>
 * 第一次错误:
 * <p>
 * 未考虑数组长度为1的情况
 * <p>
 * 输入
 * [1]
 * 输出
 * 0
 * 预期结果
 * 1
 * <p>
 * <p>
 * 第二次错误
 * 外层循环应该到len-1
 * <p>
 * 输入
 * [-2,1]
 * 输出
 * -1
 * 预期结果
 * 1
 * <p>
 * <p>
 * 第三次错误
 * 暂存累加结果数组长度错误
 * <p>
 * 输入
 * [-2,-1]
 * 输出
 * 0
 * 预期结果
 * -1
 *
 * 第四次错误
 * 暂存累加结果数组长度错误-未考虑外层第一个数就是最大的情况
 * 输入
 * [-1,-2]
 * 输出
 * -2
 * 预期结果
 * -1
 */
public class Solution53 {

    public int maxSubArray(int[] nums) {
        int max = 0;
        boolean firstTime = true;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int[] result = new int[len - i];
            int sum = nums[i]; // 暂存当前累加
            int tmp = 0; // 用于判断每次累加结果,数组
            if (i < len - 1) {
                result[0] = sum;
                for (int j = i + 1; j < len; j++) {
                    sum = sum + nums[j];
                    result[j - i] = sum; // 将当前累加结果放入数组
                }
                //
                tmp = result[0];
                for (int k = 1; k < result.length; k++) {
                    tmp = tmp < result[k] ? result[k] : tmp;
                }
            } else {
                tmp = sum;
            }
            if (firstTime) {
                max = tmp;
                firstTime = false;
            } else {
                max = max < tmp ? tmp : max;
            }
        }
        return max;
    }

    public static void main(String[] args) {


        System.out.println(new Solution53().maxSubArray(ArrayHelper.genIntArray(-2, -1)));
        System.out.println(new Solution53().maxSubArray(ArrayHelper.genIntArray(-2, 1)));
        System.out.println(new Solution53().maxSubArray(ArrayHelper.genIntArray(1)));
        System.out.println(new Solution53().maxSubArray(ArrayHelper.genIntArray(-2, 1, -3, 4, -1, 2, 1, -5, 4)));

    }
}

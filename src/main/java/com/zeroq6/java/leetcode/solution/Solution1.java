package com.zeroq6.java.leetcode.solution;


import com.alibaba.fastjson.JSON;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * <p>
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        lab:
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break lab;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Object result = new Solution1().twoSum(new int[]{1, 1, 5, 5, 6}, 10);

        System.out.println(JSON.toJSONString(result));
    }
}


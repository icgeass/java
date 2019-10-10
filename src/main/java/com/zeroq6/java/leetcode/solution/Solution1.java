package com.zeroq6.java.leetcode.solution;


import com.alibaba.fastjson.JSON;
import com.zeroq6.java.leetcode.solution.help.ArrayHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 注意题目：你可以假设每种输入只会对应一个答案。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsCopy);
        int first = 0;
        int last = numsCopy.length - 1;
        int sum = numsCopy[first] + numsCopy[last];
        int[] result = new int[]{-1, -1};
        while (sum != target) {
            if (sum > target) {
                // sum大则尾指针前移，减小sum
                last--;
            } else {
                // sum小则头指针后移，增大sum
                first++;
            }
            // 不可能出现break了但是未找到的情况，因为题目指定只有一个结果
            if (first >= last) {
                break;
            }
            sum = numsCopy[first] + numsCopy[last];
        }
        // 查找原始位置
        for (int i = 0; i < nums.length; i++) {
            if (result[0] == -1 && nums[i] == numsCopy[first]) {
                result[0] = i;
            } else if (result[1] == -1 && nums[i] == numsCopy[last]) {
                result[1] = i;
            }
        }
        return result;
    }


    /**
     * 使用字典法
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> dict = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (dict.get(diff) != null) {
                result[0] = dict.get(diff);
                result[1] = i;
                return result;
            }
            dict.put(nums[i], i);
        }
        return null;
    }


    public static void main(String[] args) {
        Object result = new Solution1().twoSum(ArrayHelper.genIntArray(2, 7, 11, 15), 9);
        System.out.println(JSON.toJSONString(result));

        result = new Solution1().twoSum1(ArrayHelper.genIntArray(3, 3), 6);

        System.out.println(JSON.toJSONString(result));

        result = new Solution1().twoSum2(ArrayHelper.genIntArray(3, 2, 4), 6);

        System.out.println(JSON.toJSONString(result));

        System.out.println();
    }
}


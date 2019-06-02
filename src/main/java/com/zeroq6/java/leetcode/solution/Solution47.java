package com.zeroq6.java.leetcode.solution;


import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 * <p>
 * <p>
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> transfer = new ArrayList<>();
        if (null == nums) {
            nums = new int[0];
        }
        for (int i = 0; i < nums.length; i++) {
            transfer.add(nums[i]);
        }

        return parse(transfer);

    }


    public List<List<Integer>> parse(List<Integer> list) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            return result;
        }
        if (list.size() == 1) {
            result.add(list);
            return result;
        }
        List<Integer> duplicate = new ArrayList<Integer>();
        //如果size大于1
        for (Integer integer : list) {
            if(duplicate.contains(integer)){
                continue;
            }
            duplicate.add(integer);
            // 去除当前integer
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(list);
            tmp.remove(integer);
            // 得到去除当前integer的所有排列
            for (List<Integer> integerList : parse(tmp)) {
                integerList.add(0, integer);
                result.add(integerList);
            }

        }
        return result;


    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new Solution47().permuteUnique(null)));
        System.out.println(JSON.toJSONString(new Solution47().permuteUnique(new int[]{})));
        System.out.println(JSON.toJSONString(new Solution47().permuteUnique(new int[]{1})));
        System.out.println(JSON.toJSONString(new Solution47().permuteUnique(new int[]{1, 2})));
        System.out.println(JSON.toJSONString(new Solution47().permuteUnique(new int[]{1, 2, 3})));
        System.out.println(JSON.toJSONString(new Solution47().permuteUnique(new int[]{1, 1, 2})));
    }
}

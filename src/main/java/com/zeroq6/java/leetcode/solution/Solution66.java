package com.zeroq6.java.leetcode.solution;


import com.alibaba.fastjson.JSON;
import com.zeroq6.java.leetcode.solution.help.ArrayHelper;

/**
 * https://leetcode-cn.com/problems/plus-one/
 * <p>
 * <p>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class Solution66 {


    public int[] plusOne(int[] digits) {
        int nextAdd = 0;
        int tmp = 0;
        for (int i = digits.length - 1; i > -1; i--) {
            if (i == digits.length - 1) {
                tmp = digits[i] + 1 + nextAdd;
            } else {
                tmp = digits[i] + nextAdd;
            }
            digits[i] = tmp % 10;
            nextAdd = tmp / 10;
            if (nextAdd == 0) {
                break;
            }
        }
        if (nextAdd == 0) {
            return digits;
        } else {
            int[] re = new int[digits.length + 1];
            re[0] = 1;
            for (int i = 1; i < re.length; i++) {
                re[i] = digits[i - 1];
            }
            return re;
        }

    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new Solution66().plusOne(ArrayHelper.genIntArray(1))));
        System.out.println(JSON.toJSONString(new Solution66().plusOne(ArrayHelper.genIntArray(9))));
        System.out.println(JSON.toJSONString(new Solution66().plusOne(ArrayHelper.genIntArray(1, 2, 3))));
        System.out.println(JSON.toJSONString(new Solution66().plusOne(ArrayHelper.genIntArray(1, 2, 9))));
        System.out.println(JSON.toJSONString(new Solution66().plusOne(ArrayHelper.genIntArray(9, 9, 9))));


    }
}



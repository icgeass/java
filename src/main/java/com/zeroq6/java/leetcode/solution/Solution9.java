package com.zeroq6.java.leetcode.solution;


/**
 * https://leetcode-cn.com/problems/palindrome-number/
 * <p>
 * <p>
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class Solution9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int tmp = x;
        int other = 0;
        while (x != 0) {
            other = other * 10 + x % 10;
            x = x / 10;
        }
        return other == tmp;

    }


    public static void main(String[] args) {
        System.out.println(new Solution9().isPalindrome(-11));
        System.out.println(new Solution9().isPalindrome(0));
        System.out.println(new Solution9().isPalindrome(1));
        System.out.println(new Solution9().isPalindrome(1234321));
        System.out.println(new Solution9().isPalindrome(79097));
        System.out.println(new Solution9().isPalindrome(1534236469));

    }
}

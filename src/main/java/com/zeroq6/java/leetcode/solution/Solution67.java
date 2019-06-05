package com.zeroq6.java.leetcode.solution;


/**
 * https://leetcode-cn.com/problems/add-binary/
 * <p>
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class Solution67 {


    /**
     * 大数相加
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        int nextAdd = 0;
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder("");
        while (i < len1 || i < len2) {
            int tmp1 = 0;
            int tmp2 = 0;
            if (i < len1) {
                tmp1 = a.charAt(len1 - i - 1) - '0';
            }
            if (i < len2) {
                tmp2 = b.charAt(len2 - i - 1) - '0';
            }
            int sum = nextAdd + tmp1 + tmp2;
            stringBuilder.insert(0, sum % 2);
            nextAdd = sum / 2;
            i++;

        }
        if (nextAdd > 0) {
            stringBuilder.insert(0, 1);
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {

        System.out.println(new Solution67().addBinary("11", "1"));
        System.out.println(new Solution67().addBinary("1010", "1011"));
        //
        System.out.println(new Solution67().addBinary("0", "1"));
        System.out.println(new Solution67().addBinary("100", "1"));

    }
}

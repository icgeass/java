package com.zeroq6.java.leetcode.solution;


/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 *
 * 第一次错误
 *
 * 查找到不相等未跳出外层循环
 *
 *
 */
public class Solution14 {

    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if(null == strs || strs.length == 0){
            return result;
        }
        int len = strs[0].length();  // 字符串数组中最小长度字符串长度
        // 查找最小长度
        for (int i = 1; i < strs.length; i++) {
            int length = strs[i].length();
            len = len > length ? length : len;
        }
        // 查找相同
        lab:
        for (int i = 0; i < len; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(ch != strs[j].charAt(i)){
                    break lab;
                }
            }
            result = result.concat(ch + "");
        }
        return result;

    }


    public static void main(String[] args) {
        System.out.println(new Solution14().longestCommonPrefix(new String[]{"flower","flow","flight"}));

        System.out.println(new Solution14().longestCommonPrefix(new String[]{"dog","racecar","car"}));

        System.out.println(new Solution14().longestCommonPrefix(new String[]{"aca","cba"}));



    }
}

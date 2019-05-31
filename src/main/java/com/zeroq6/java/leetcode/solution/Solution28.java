package com.zeroq6.java.leetcode.solution;


/**
 * https://leetcode-cn.com/problems/implement-strstr/
 * <p>
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * 第一次错误
 *
 * 未判断j==len2，直接返回
 */
public class Solution28 {


    public int strStr(String haystack, String needle) {
        if (null == haystack || null == needle) {
            return -1;
        }
        int len2 = needle.length();
        if (len2 == 0) {
            return 0;
        }
        int len1 = haystack.length();
        if (len1 < len2) {
            return -1;
        }
        for (int i = 0; i <= len1 - len2; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j;
                for (j = 1; j < len2; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
                if(j == len2){
                    return i;
                }
            }
        }
        return -1;


    }


    public static void main(String[] args) {
        System.out.println(new Solution28().strStr("mississippi", "issip"));
        System.out.println(new Solution28().strStr("helloll", "ll"));
        System.out.println(new Solution28().strStr("aaaaa", "bba"));


    }

}

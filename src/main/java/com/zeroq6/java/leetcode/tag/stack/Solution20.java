package com.zeroq6.java.leetcode.tag.stack;


/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * <p>
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class Solution20 {

    public boolean isValid(String s) {

        StringBuilder stringBuilder = new StringBuilder();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            int stringBuilderLen = stringBuilder.length();
            if (stringBuilderLen > 0) {  // 出栈
                char matchTo = stringBuilder.charAt(stringBuilderLen - 1);
                if (matchTo == '[' && ch == ']' || matchTo == '{' && ch == '}' || matchTo == '(' && ch == ')') {
                    stringBuilder.deleteCharAt(stringBuilderLen - 1);
                    continue;
                }
            }
            stringBuilder.append(ch); // 入栈
        }

        return stringBuilder.length() == 0;
    }


    public static void main(String[] args) {
        System.out.println(new Solution20().isValid("()"));
        System.out.println(new Solution20().isValid("{}()[]"));
        System.out.println(new Solution20().isValid("(]"));
        System.out.println(new Solution20().isValid("([)]"));
        System.out.println(new Solution20().isValid("{[]}"));


    }
}

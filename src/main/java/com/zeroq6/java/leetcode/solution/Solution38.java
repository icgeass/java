package com.zeroq6.java.leetcode.solution;


/**
 * https://leetcode-cn.com/problems/count-and-say/
 * <p>
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 */
public class Solution38 {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String say = countAndSay(n - 1);
        String result = "";
        char curr = say.charAt(0);
        int num = 1;
        char tmp;
        for (int i = 1; i < say.length(); i++) {
            tmp = say.charAt(i);
            if (curr == tmp) {
                num++;
            } else {
                result = result.concat("" + num + curr);
                curr = tmp;
                num = 1;
            }
        }
        result = result.concat("" + num + curr);
        return result;

    }

    public static void main(String[] args) {

        System.out.println(new Solution38().countAndSay(1));
        System.out.println(new Solution38().countAndSay(2));
        System.out.println(new Solution38().countAndSay(3));
        System.out.println(new Solution38().countAndSay(4));
        System.out.println(new Solution38().countAndSay(5));


    }
}

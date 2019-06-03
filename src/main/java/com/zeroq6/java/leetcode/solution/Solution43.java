package com.zeroq6.java.leetcode.solution;


/**
 * https://leetcode-cn.com/problems/multiply-strings/
 * <p>
 * 43. 字符串相乘
 * <p>
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Solution43 {


    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        return multiply0(num1, num2, num2.length() - 1, num2.length() - 1);

    }


    /**
     * num1 被乘数
     * num2 乘数
     *
     * @param num1
     * @param num2
     * @param sum2TotalPos
     * @param sum2Pos
     * @return
     */
    private String multiply0(String num1, String num2, int sum2TotalPos, int sum2Pos) {
        if (sum2Pos < 0) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder("");

        int nextToAdd = 0;// 进位

        char ch = num2.charAt(sum2Pos);

        for (int i = num1.length() - 1; i > -1; i--) {
            int re = (ch - '0') * (num1.charAt(i) - '0') + nextToAdd;
            if (re > 9) {
                nextToAdd = re / 10;
            } else {
                nextToAdd = 0;
            }
            stringBuilder.insert(0, re % 10);

        }
        if (nextToAdd > 0) {
            stringBuilder.insert(0, nextToAdd);
        }
        // 当前乘以的位数,如果为十位及以上则后面添加对应的0
        for (int i = 0; i < sum2TotalPos - sum2Pos; i++) {
            stringBuilder.append('0');
        }
        return add0(stringBuilder.toString(), multiply0(num1, num2, sum2TotalPos, --sum2Pos));


    }


    private String add0(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder("");
        int nextToAdd = 0; // 记录进位
        int pos1 = num1.length() - 1;
        int pos2 = num2.length() - 1;
        while (pos1 >= 0 || pos2 >= 0) {

            char ch1 = pos1 < 0 ? '0' : num1.charAt(pos1);
            char ch2 = pos2 < 0 ? '0' : num2.charAt(pos2);
            int sum = ch1 + ch2 - '0' - '0' + nextToAdd;
            if (sum > 9) {
                nextToAdd = 1; // 相加只能进位1
            } else {
                nextToAdd = 0; // 不进位
            }
            stringBuilder.insert(0, sum % 10);

            //
            if (pos1 >= 0) {
                pos1--;
            }
            if (pos2 >= 0) {
                pos2--;

            }
        }
        if (nextToAdd == 1) {
            stringBuilder.insert(0, 1);
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Solution43().multiply("123", "0"));
        System.out.println(new Solution43().multiply("123", "1"));
        System.out.println(new Solution43().multiply("123", "456"));


    }
}

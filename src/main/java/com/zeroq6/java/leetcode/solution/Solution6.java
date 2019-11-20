package com.zeroq6.java.leetcode.solution;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution6 {
    public String convert(String s, int numRows) {
        int len = s.length();
        if(numRows <= 1){
            return s;
        }
        StringBuilder result = new StringBuilder(len);
        int peroid = numRows + numRows - 2;
        // 列长度,如果不足1个周期,算作1个周期
        int colNum = 0;
        if (len < peroid) {
            colNum = 1;
        } else {
            colNum = len % peroid == 0 ? len / peroid : len / peroid + 1;
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < colNum; j++) {
                // 第一行和最后一行中间没有间隔数字
                int pos = i + j * peroid;
                if (pos < len) {
                    result.append(s.charAt(pos));
                }
                // 对于中间间隔数字,最大为period-2,最小为2,每向下一行减小2
                if (i != 0 && peroid - i * 2 > 0) {
                    int midPos = pos + peroid - i * 2;
                    if (midPos < len) {
                        result.append(s.charAt(midPos));
                    }
                }

            }

        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution6().convert("LEETCODEISHIRING", 3));
        System.out.println(new Solution6().convert("LEETCODEISHIRING", 4));
        System.out.println(new Solution6().convert("1234", 4));
        System.out.println(new Solution6().convert("", 0));
        System.out.println(new Solution6().convert("", 1));

        System.out.println(new Solution6().convert("123456", 4));
        System.out.println(new Solution6().convert("1234", 3));
        System.out.println(new Solution6().convert("A", 1));
        System.out.println(new Solution6().convert("AB", 1));
        System.out.println(new Solution6().convert("1234567", 2));







    }

}


package com.zeroq6.java.leetcode.solution;


/**
 * https://leetcode-cn.com/problems/reverse-integer/
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 第一次错误：越界条件判断错误
 * <p>
 * 输入
 * 1534236469
 * 输出
 * 1056389759
 * 预期结果
 * 0
 */
public class Solution7 {
    public int reverse(int x) {
        int result = 0;
        int tmp1 = 0; // 暂存 x/10
        int tmp2 = 0; // 暂存 x%10
        while ((tmp1 = x / 10) != 0) {
            tmp2 = x % 10;
            // 检查越界
            if (x > 0) {
                if (result > (Integer.MAX_VALUE - tmp2) / 10) {
                    return 0;
                }
            } else if (x < 0) {
                if (result < (Integer.MAX_VALUE - tmp2) / 10) {
                    return 0;
                }
            }
            result = result * 10 + tmp2;
            x = tmp1;
        }
        // 检查越界
        if (x > 0) {
            if (result > (Integer.MAX_VALUE - x % 10) / 10) {
                return 0;
            }
        } else if (x < 0) {
            if (result < (Integer.MAX_VALUE - x % 10) / 10) {
                return 0;
            }
        }
        // 最后一个数
        result = result * 10 + x % 10;
        return result;

    }


    public static void main(String[] args) {

        System.out.println((int) (Math.pow(2, 31) - 1) == Integer.MAX_VALUE);
        System.out.println((int) (-Math.pow(2, 31)) == Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE + "," + Integer.MIN_VALUE);


        System.out.println(new Solution7().reverse(12300));
        System.out.println(new Solution7().reverse(123456));
        System.out.println(new Solution7().reverse(1534236469));

    }
}


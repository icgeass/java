package com.zeroq6.java.leetcode.solution;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution5 {


    /**
     * 逆序字符串,查找最长子串
     * 用位移的方法查找最长子串
     * 例如:
     * 第一种情况:
     * | 1213
     * |3121
     * 或
     * 第二种情况:
     * |1213
     * | 3121
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        //
        if (s.length() == 0) {
            return "";
        }
        int[] tmp = new int[s.length()];
        int[] pointsTmp = null;
        int[] points = new int[2];
        // i表示移位,用于查找最长子串
        for (int i = 0; i < s.length(); i++) {
            int index = 0;
            // 以左边为准,第一种情况,每次位移,相当于基准减小,所以-i
            for (int j = 0; j < s.length() - i; j++) {
                tmp[index++] = s.charAt(j) - s.charAt(s.length() - 1 - j - i);
            }
            pointsTmp = getZeroRangeIndex(tmp, 0, s.length() - 1 - i, s);
            if (pointsTmp[1] - pointsTmp[0] + 1 > points[1] - points[0] + 1) {
                points = pointsTmp;
            }
            // 以右边为准,第二种情况,每次位移,相当于基准增加,所以+i
            index = 0;
            for (int j = i; j < s.length(); j++) {
                tmp[i + index++] = s.charAt(j) - s.charAt(s.length() - 1 - j + i);
            }
            pointsTmp = getZeroRangeIndex(tmp, i, s.length() - 1, s);
            if (pointsTmp[1] - pointsTmp[0] + 1 > points[1] - points[0] + 1) {
                points = pointsTmp;
            }

        }
        return s.substring(points[0], points[1] + 1);

    }


    /**
     * 获取数组ints中最长连续为0的开始结束位置
     *
     * @param ints
     * @param fromIndex
     * @param toIndex
     * @return
     */
    private int[] getZeroRangeIndex(int[] ints, int fromIndex, int toIndex, String originalString) {
        int nextBeginPoint = -1;
        int nextEndPoint = -1;
        int[] points = new int[]{0, 0};
        for (int i = fromIndex; i <= toIndex; i++) {
            if (ints[i] == 0) {
                // 记录当前连续0的开始和结束位置
                if (nextBeginPoint == -1) {
                    nextBeginPoint = i;
                }
                nextEndPoint = i;

                if (i == toIndex) {
                    updatePoints(nextBeginPoint, nextEndPoint, points, originalString);
                }

            } else {
                // 说明重置后没有找到新0位
                if (nextBeginPoint == -1) {
                    continue;
                }
                // 更新开始结束位置
                updatePoints(nextBeginPoint, nextEndPoint, points, originalString);

                nextBeginPoint = -1;
                nextEndPoint = -1;
            }
        }
        return points;
    }

    private void updatePoints(int nextBeginPoint, int nextEndPoint, int[] points, String originalString) {
        int len = nextEndPoint - nextBeginPoint + 1;
        if (len > points[1] - points[0] + 1) {
            // 排除这种情况
            // abacdfgdcaba
            // abacdgfdcaba
            String str = originalString.substring(nextBeginPoint, nextEndPoint + 1);
            int length = str.length();
            // 判断回文
            // 假设下标都从1开始:
            // 如果length为双数,则length/2正好在前一半最后的位置,而下标从0开始,则小于length/2正好满足
            // 如果length为单数,相当于双数中间的那个数舍去了,也等于前面一半最后的位置,而下标从0开始,则小于length/2正好满足
            for (int i = 0; i < length / 2; i++) {
                if (str.charAt(i) != str.charAt(len - 1 - i)) {
                    return;
                }
            }
            points[0] = nextBeginPoint;
            points[1] = nextEndPoint;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution5().longestPalindrome("1213"));
        System.out.println(new Solution5().longestPalindrome("3121"));
        System.out.println(new Solution5().longestPalindrome(""));
        System.out.println(new Solution5().longestPalindrome("aba"));
        System.out.println(new Solution5().longestPalindrome("ac"));
        System.out.println(new Solution5().longestPalindrome("abacdfgdcaba"));
        System.out.println(new Solution5().longestPalindrome("abcdbbfcba"));
        System.out.println(new Solution5().longestPalindrome("cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"));


    }
}




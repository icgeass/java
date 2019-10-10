package com.zeroq6.java.leetcode.solution;

import java.util.*;


/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isDuplicate(s, i, j)) {
                    break;
                } else {
                    if (result < j - i + 1) {
                        result = j - i + 1;
                    }
                }
            }
        }
        return result;

    }


    private boolean isDuplicate(String s, int start, int end) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (stringBuilder.indexOf(s.charAt(i) + "") > -1) {
                return true;
            } else {
                stringBuilder.append(s.charAt(i) + "");
            }
        }
        return false;

    }


    /**
     * 使用滑动窗口的方式
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int begin = 0;
        int end = 0;
        int result = 0;
        int len = s.length();
        List<Character> characterList = new ArrayList<>();
        while (begin < len && end < len) {
            // 不包含，此时begin(含)和end（含）之前的序列是各不相同的，可以计算长度。
            // 将end指向的字符加入集合，并end指针后移，更新最大长度
            if (!characterList.contains(s.charAt(end))) {
                characterList.add(s.charAt(end++));
                // 由于end已经++了，所以不需要使用end-begin+1
                result = Math.max(result, end - begin);
            } else {
                // 包含说明之前集合中的序列 和 当前end指向的字符重复了
                // begin指针后移（不移动end，因为由于加入了end重复了，所以end及其以后的字符一定都有重复的），删除begin指向的值，continue
                characterList.remove(Character.valueOf(s.charAt(begin++)));
            }
        }
        return result;

    }


    /**
     * 使用滑动窗口的方式--优化
     * <p>
     * <p>
     * 在lengthOfLongestSubstring1中，由于加入了end，而导致了重复，重复的位置可能是原不重复序列的第一个位置，
     * 也可能是原不重复序列的最后一个位置，考虑极端情况重复字符是原不重复序列的最后一个，比如 abcd dea
     * 此时没有必要 依次 移动滑动窗口的start，直接将start移动到原不重复序列的下一个即可，对于abcd dea来说就是第二个d
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int result = 0;
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int begin = 0, end = 0; end < len; end++) {
            if (map.containsKey(s.charAt(end))) {
                // 考虑abba的情况，begin已经离开导致重复的滑动窗口了，有重复也不能用之前记录的重复位置（下一个），而用begin
                begin = Math.max(begin, map.get(s.charAt(end)));
            }
            result = Math.max(result, end - begin + 1);
            map.put(s.charAt(end), end + 1);

        }
        return result;

    }


    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution3().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution3().lengthOfLongestSubstring("pwwkew"));

        System.out.println(new Solution3().lengthOfLongestSubstring1("abcabcbb"));
        System.out.println(new Solution3().lengthOfLongestSubstring1("bbbbb"));
        System.out.println(new Solution3().lengthOfLongestSubstring1("pwwkew"));
        System.out.println(new Solution3().lengthOfLongestSubstring1("abcdaef"));

        System.out.println(new Solution3().lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(new Solution3().lengthOfLongestSubstring2("bbbbb"));
        System.out.println(new Solution3().lengthOfLongestSubstring2("pwwkew"));
        System.out.println(new Solution3().lengthOfLongestSubstring2("abcdaef"));
        System.out.println(new Solution3().lengthOfLongestSubstring2("abba"));



    }
}

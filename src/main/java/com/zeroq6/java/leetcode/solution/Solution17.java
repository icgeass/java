package com.zeroq6.java.leetcode.solution;


import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * <p>
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class Solution17 {

    public List<String> letterCombinations(String digits) {
        Map<String, String> dict = new HashMap<>();
        dict.put("2", "abc");
        dict.put("3", "def");
        dict.put("4", "ghi");
        dict.put("5", "jkl");
        dict.put("6", "mno");
        dict.put("7", "pqrs");
        dict.put("8", "tuv");
        dict.put("9", "wxyz");

        return genLetterList(dict, digits);
    }


    private List<String> genLetterList(Map<String, String> dict, String digits) {
        List<String> stringList = new ArrayList<>();
        if (null == digits || digits.length() == 0) {
            return stringList;
        }
        if (digits.length() == 1) {
            return genStringListSingleChar(dict, digits);

        }

        stringList = genStringListSingleChar(dict, digits.charAt(0) + "");

        List<String> stringListNext = genLetterList(dict, digits.substring(1));

        List<String> result = new ArrayList<>();

        for (int i = 0; i < stringList.size(); i++) {
            for (int j = 0; j < stringListNext.size(); j++) {
                result.add(stringList.get(i).concat(stringListNext.get(j)));

            }
        }
        return result;

    }


    private List<String> genStringListSingleChar(Map<String, String> dict, String digits) {
        List<String> stringList = new ArrayList<>();
        if (null == digits || digits.length() == 0) {
            throw new RuntimeException("digits.length() must = 1");
        }
        if (digits.length() == 1) {
            String value = dict.get(digits);
            for (int i = 0; i < value.length(); i++) {
                stringList.add(value.charAt(i) + "");
            }
        } else {
            throw new RuntimeException("digits.length() must = 1");
        }
        return stringList;
    }


    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new Solution17().letterCombinations("2")));
        System.out.println(JSON.toJSONString(new Solution17().letterCombinations("23")));


    }
}

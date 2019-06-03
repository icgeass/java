package com.zeroq6.java.leetcode.solution.help;

public class ArrayHelper {


    public static int[] genIntArray(int... ints) {
        if (null == ints || ints.length == 0) {
            return new int[]{};
        }
        int[] result = new int[ints.length];
        for (int i = 0; i < ints.length; i++) {
            result[i] = ints[i];
        }
        return result;
    }
}

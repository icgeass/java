package com.zeroq6.java.algorithm.sort.utils;

import java.util.Arrays;
import java.util.Random;

public class SortUtils {

    private static int MAX_INT = 20;

    private static int INT_ARRAY_LENGTH = 10;

    public static int[] getIntArray(int... arr) {
        if (null == arr) {
            return new int[0];
        }
        return arr;
    }

    public static int[] getRandomIntArray() {
        return getRandomIntArray(INT_ARRAY_LENGTH, MAX_INT, true);
    }

    public static int[] getRandomIntArray(int length) {
        return getRandomIntArray(length, MAX_INT, true);
    }

    public static int[] getRandomIntArray(int length, boolean print) {
        return getRandomIntArray(length, MAX_INT, print);
    }

    public static int[] getRandomIntArray(int length, int maxInt, boolean print) {
        Random random = new Random();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = random.nextInt(maxInt + 1);
        }
        if (print) {
            print(result);
        }
        return result;
    }


    public static void print(int[] arr) {
        Arrays.stream(arr).boxed().map(i -> i + " ").forEach(System.out::print);
        System.out.println();
    }
}

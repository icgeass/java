package com.zeroq6.java.algorithm.sort.utils;

import java.util.Arrays;
import java.util.Random;

public class SortUtils {

    public static int[] getIntArray(int... arr) {
        if (null == arr) {
            return new int[0];
        }
        return arr;
    }

    public static int[] getRandomIntArray(int length) {
        return getRandomIntArray(length, 100);
    }

    public static int[] getRandomIntArray(int length, int maxInt) {
        Random random = new Random();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = random.nextInt(maxInt + 1);
        }
        return result;
    }


    public static void print(int[] arr) {
        Arrays.stream(arr).boxed().map(i -> i + " ").forEach(System.out::print);
        System.out.println();
    }
}

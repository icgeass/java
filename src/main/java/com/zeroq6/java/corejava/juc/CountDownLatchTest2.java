package com.zeroq6.java.corejava.juc;

import java.util.concurrent.CountDownLatch;

/**
 * 可以countDown多次
 */
public class CountDownLatchTest2 {

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        countDownLatch.countDown();
        countDownLatch.countDown();
        countDownLatch.countDown();
        System.out.println(countDownLatch.getCount());
        countDownLatch.await();
        System.out.println("------------------");
    }
}

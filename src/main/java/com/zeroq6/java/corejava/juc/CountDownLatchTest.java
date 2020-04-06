package com.zeroq6.java.corejava.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

public class CountDownLatchTest {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        System.out.println("prepare play...");
        ExecutorService executorService = JucUtils.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            executorService.submit(() -> new Player(countDownLatch).play());
        }
        countDownLatch.await();
        System.out.println("all wait ok, do play card");

    }


    static class Player {
        private CountDownLatch countDownLatch;

        public Player(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        public void play() {
            JucUtils.randomSleep();
            System.out.println(Thread.currentThread().getName() + " already ok");
            this.countDownLatch.countDown();
        }
    }

}

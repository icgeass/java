package com.zeroq6.java.corejava.juc;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {


    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(10);
        ExecutorService executorService = JucUtils.newFixedThreadPool(10);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Task(semaphore, new Random().nextInt(3) + 1));
        }
        Thread.sleep(6000L);
        executorService.shutdown();


    }

    static class Task implements Runnable {

        private Semaphore semaphore;

        private int n;

        public Task(Semaphore semaphore, int n) {
            this.semaphore = semaphore;
            this.n = n;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire(n);
                System.out.println(System.currentTimeMillis() / 1000 + " " + Thread.currentThread().getName() + " acquired " + n);
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release(n);
                System.out.println(System.currentTimeMillis() / 1000 + " " + Thread.currentThread().getName() + " released " + n);
            }
        }
    }
}

package com.zeroq6.java.corejava.juc;


import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读读共享，写写互斥，读写互斥，写读互斥
 *
 * https://www.jianshu.com/p/4b45f9a1f7d2
 */
public class ReentrantReadWriteLockTest {


    public static void main(String[] args) {
        Random random = new Random();
        MyTask myTask = new MyTask();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                if (random.nextBoolean()) {
                    myTask.read();
                } else {
                    myTask.write();
                }
            }).start();
        }
    }

    static class MyTask {

        private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        public void read() {
            try {
                lock.readLock().lock();
                System.out.println(Thread.currentThread().getName() + " read start");
                Thread.sleep(10000);
                System.out.println(Thread.currentThread().getName() + " read end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.readLock().unlock();
            }
        }

        public void write() {
            try {
                lock.writeLock().lock();
                System.out.println(Thread.currentThread().getName() + " write start");
                Thread.sleep(10000);
                System.out.println(Thread.currentThread().getName() + " write end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.writeLock().unlock();
            }
        }
    }
}

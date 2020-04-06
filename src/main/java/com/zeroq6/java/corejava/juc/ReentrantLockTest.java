package com.zeroq6.java.corejava.juc;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                System.out.println(JucUtils.currentSeconds() + " subThread locked...");
                JucUtils.randomSleep();
                reentrantLock.unlock();
            }
        }).start();
        System.out.println(JucUtils.currentSeconds() + " subThread started");
        reentrantLock.lock();
        System.out.println(JucUtils.currentSeconds() + " mainThread locked");
        reentrantLock.unlock();
        System.out.println(JucUtils.currentSeconds() + " mainThread unlocked");

    }
}

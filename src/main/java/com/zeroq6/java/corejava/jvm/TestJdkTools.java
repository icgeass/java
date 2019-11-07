package com.zeroq6.java.corejava.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟死锁，内存，CPU占用
 * <p>
 * 使用jdk工具排查
 * <p>
 * -Xms128m -Xmx128m -Xss1m
 */
public class TestJdkTools {

    private final static Object lock1 = new Object();

    private final static Object lock2 = new Object();

    private static List<byte[]> bytes = new ArrayList<>();

    private static List<TestJdkTools[]> objects = new ArrayList<>();

    private static void acquire1() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getId() + "-acquire-lock1");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getId() + "-acquire-lock2");
            }
        }
    }

    private static void acquire2() {
        synchronized (lock2) {
            System.out.println(Thread.currentThread().getId() + "-acquire-lock2");
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getId() + "-acquire-lock1");
            }
        }
    }


    private static void deadLock() {
        new Thread(TestJdkTools::acquire1, "com.zeroq6.java.corejava.jvm.TestJdkTools.deadLock-thread1").start();
        new Thread(TestJdkTools::acquire2, "com.zeroq6.java.corejava.jvm.TestJdkTools.deadLock-thread2").start();

    }


    private static void consumeCPU() {
        new Thread(() -> {
            int i = 0;
            while (true) {
                i++;
            }
        }, "com.zeroq6.java.corejava.jvm.TestJdkTools-consumeCPU-thread").start();
    }

    private static void outOfMemory() {
        int n = 0;
        while (true) {
            try {
                Thread t = new Thread(() -> {
                    while (true) {
                        bytes.add(new byte[1024 * 1024 * 16]);
                        objects.add(new TestJdkTools[1024 * 1024 * 16]);
                    }
                }, "com.zeroq6.java.corejava.jvm.TestJdkTools-outOfMemory-thread-" + n++);
                t.start();
                t.join();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bytes.clear();
                objects.clear();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("-Xms128m -Xmx128m -Xss1m");
        deadLock();
        consumeCPU();
        outOfMemory();
    }


}

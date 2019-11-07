package com.zeroq6.java.corejava.jvm;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;

/**
 * 模拟死锁，内存，CPU占用
 * <p>
 * 使用jdk工具排查
 * <p>
 * -Xms32m -Xmx32m
 */
public class JdkTools {

    private final static Object lock1 = new JdkTools();

    private final static Object lock2 = new JdkTools();

    private final static List<char[]> chars = new ArrayList<>();

    private final static List<DemoObject> objects = new ArrayList<>();

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
        new Thread(JdkTools::acquire1, "JdkTools.deadLock-thread1").start();
        new Thread(JdkTools::acquire2, "JdkTools.deadLock-thread2").start();

    }


    private static void consumeCPU() {
        new Thread(() -> {
            int i = 0;
            while (true) {
                i++;
            }
        }, "JdkTools-consumeCPU-thread").start();
    }

    private static void outOfMemory() {
        int n = 0;
        while (true) {
            try {
                Thread t = new Thread(() -> {
                    int size = 1024 * 1024;
                    while (true) {
                        chars.add(new char[size]);
                        for (int i = 0; i < size; i++) {
                            objects.add(new DemoObject());
                        }
                    }
                }, "JdkTools-outOfMemory-thread-" + n++);
                t.start();
                t.join();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    Thread.sleep(1000 * 20L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                chars.clear();
                objects.clear();
            }
        }
    }

    public static void main(String[] args) {
        MemoryMXBean memoryMBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage usage = memoryMBean.getHeapMemoryUsage();
        int maxSize = 1024 * 1024 * 32;
        if (usage.getInit() > maxSize || usage.getMax() > maxSize) {
            System.out.println("Use: -Xms32m -Xmx32m");
            return;
        }
        deadLock();
        consumeCPU();
        outOfMemory();
    }


}

class DemoObject {
    int a = 10086;
    long[] longs = new long[1024];
}
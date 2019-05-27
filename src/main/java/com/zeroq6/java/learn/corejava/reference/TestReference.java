package com.zeroq6.java.learn.corejava.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * VM参数：-Xms10m -Xmx30m -Xss108k
 * <p>
 * 结论：
 * 1. 强引用把强引用指向null则会被gc回收，如果在finalize方法将对象再次强引用则不会回收（一般不会这么做，这里只是为了测试）
 * 2. 软引用只有在堆内存到达临界时才会回收，常用于缓存，如果每次对象容量增加过大或增加速度过快，仍然可能OOM
 * 3. 弱引用只要垃圾回收器扫描到就会被回收，用于缓存，内存敏感的，
 * 4. 虚引用只是结合引用队列判别该对象是否已回收，实际很少用到
 * <p>
 * 如果软引用或弱引用与强引用同时指向一个对象，则该对象不会被回收，即只要有强引用，软引用和弱引用特性不会生效
 *
 * https://community.oracle.com/blogs/enicholas/2006/05/04/understanding-weak-references
 * https://droidyue.com/blog/2014/10/12/understanding-weakreference-in-java/（译文）
 * https://blog.csdn.net/mazhimazh/article/details/19752475
 *
 *
 */
public class TestReference {

    /**
     * 和 BIG_CLASS_DATA_SIZE_IN_BYTE  乘起来比Xmx大就可以达到测试效果
     */
    public final static int BIG_CLASS_ARRAY_SIZE = 15;


    /**
     * 每个对象的大小，如果设置过大，SoftReference会报OOM，因为递增太大了，JVM没有判断出到了临界状态
     */
    public final static int BIG_CLASS_DATA_SIZE_IN_BYTE = 1024 * 1024 * 2;

    /**
     * 对象增加间隔时间，如果过短，则可能在JVM来不及回收对象就报OOM
     */
    public final static long PEROID_PER_GC_MANUAL = 2000L;

    /**
     * 在强引用测试中是否将强引用指向null以便回收对象，true则会正常回收，false不会回收（因为有强引用），引发OOM
     */
    public final static boolean POINT_NULL_IN_STRONG_REFERENCE = true;

    /**
     * 在强引用测试中是否在finalize方法中再次加入强引用，true则会导致OOM，每个对象只可能调用finalize一次
     */
    public final static boolean RESURRECT_IN_STRONG_REFERENCE = false;


    public static void main(String[] args) throws Exception {


        System.out.println("------strongReference------");
        strongReference();

        System.out.println("------softReference------");
        softReference();

        System.out.println("------weakReference------");
        weakReference();
    }

    public static void strongReference() throws Exception {
        BigClass[] arr = new BigClass[BIG_CLASS_ARRAY_SIZE];
        // 描述
        String desc = POINT_NULL_IN_STRONG_REFERENCE ? " point to null" : " NOT point to null";
        desc = RESURRECT_IN_STRONG_REFERENCE ? desc + ", resurrect" : desc + ", NOT resurrect";
        for (int i = 0; i < BIG_CLASS_ARRAY_SIZE; i++) {
            arr[i] = new BigClass(i, "strongReference");
            System.out.println(arr[i] + desc);
            if (POINT_NULL_IN_STRONG_REFERENCE) {
                arr[i] = null;
            }
            System.gc();
            Thread.sleep(PEROID_PER_GC_MANUAL);
        }
    }

    public static void softReference() throws Exception {
        ReferenceQueue<BigClass> referenceQueue = new ReferenceQueue<BigClass>();
        Thread thread = new Thread(() -> {
            try {
                SoftReference<BigClass> softReference;
                while ((softReference = (SoftReference) referenceQueue.remove()) != null) {
                    System.out.println("recycling: " + softReference);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.setDaemon(true);
        thread.start();

        SoftReference<BigClass>[] arr = new SoftReference[BIG_CLASS_ARRAY_SIZE];
        for (int i = 0; i < BIG_CLASS_ARRAY_SIZE; i++) {
            BigClass tmp = new BigClass(i, "softReference");
            arr[i] = new SoftReference<BigClass>(tmp, referenceQueue);
            tmp = null;
            System.gc();
            Thread.sleep(PEROID_PER_GC_MANUAL);
            System.out.println(arr[i].get() + "---" + arr[i] + "---get.after.gc");
        }

    }

    public static void weakReference() throws Exception {
        ReferenceQueue<BigClass> referenceQueue = new ReferenceQueue<BigClass>();
        Thread thread = new Thread(() -> {
            try {
                WeakReference<BigClass> weakReference;
                while ((weakReference = (WeakReference) referenceQueue.remove()) != null) {
                    System.out.println("recycling: " + weakReference);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.setDaemon(true);
        thread.start();
        //
        WeakReference<BigClass>[] arr = new WeakReference[BIG_CLASS_ARRAY_SIZE];
        for (int i = 0; i < BIG_CLASS_ARRAY_SIZE; i++) {
            BigClass tmp = new BigClass(i, "weakReference");
            arr[i] = new WeakReference<BigClass>(tmp, referenceQueue);
            tmp = null;
            System.out.println(arr[i].get() + "---" + arr[i] + "---get.before.gc");
            System.gc();
            Thread.sleep(PEROID_PER_GC_MANUAL);
            System.out.println(arr[i].get() + "---" + arr[i] + "---get.after.gc");
        }
    }
}


package com.zeroq6.java.leetcode.solution;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 我们提供了一个类：
 * <p>
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: "onetwothree"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 * 正确的输出是 "onetwothree"。
 * 示例 2:
 * <p>
 * 输入: [1,3,2]
 * 输出: "onetwothree"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
 * 正确的输出是 "onetwothree"。
 *  
 * <p>
 * 注意:
 * <p>
 * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
 * <p>
 * 你看到的输入格式主要是为了确保测试的全面性。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1114 {


    public static void main(String[] args) {

        final Foo foo = new Foo();

        Runnable t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("first");
            }
        };
        Runnable t2 = new Thread(){
            @Override
            public void run() {
                System.out.println("two");
            }
        };
        Runnable t3 = new Thread(){
            @Override
            public void run() {
                System.out.println("three");
            }
        };

        for (int i = 0; i < 100; i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        foo.first(t1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            new Thread(){
                @Override
                public void run() {
                    try {
                        foo.second(t2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            new Thread(){
                @Override
                public void run() {
                    try {
                        foo.third(t3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }




    }
}

class Foo {

    public Foo() {

    }

    private AtomicInteger atomicInteger = new AtomicInteger(0);




    public void first(Runnable printFirst) throws InterruptedException {
        while (!atomicInteger.compareAndSet(0, 1));
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        while (!atomicInteger.compareAndSet(1, 2));
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (!atomicInteger.compareAndSet(2, 3));
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        while (!atomicInteger.compareAndSet(3, 4));
    }
    public void third(Runnable printThird) throws InterruptedException {
        while (!atomicInteger.compareAndSet(4, 5));
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        while (!atomicInteger.compareAndSet(5, 0));
    }
}
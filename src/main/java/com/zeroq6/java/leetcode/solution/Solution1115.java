package com.zeroq6.java.leetcode.solution;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 我们提供一个类：
 * <p>
 * class FooBar {
 * public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 * }
 * <p>
 * public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 * }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 * <p>
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * 示例 2:
 * <p>
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-foobar-alternately
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1115 {


    public static void main(String[] args) {

    }
}


class FooBar {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private volatile AtomicInteger size = new AtomicInteger(0);

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            if (size.get() > 0) {
                condition.await();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            size.addAndGet(1);
            condition.signal();
            lock.unlock();

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            if (size.get() == 0) {
                condition.await();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            size.addAndGet(-1);
            printBar.run();
            condition.signal();
            lock.unlock();
        }
    }
}

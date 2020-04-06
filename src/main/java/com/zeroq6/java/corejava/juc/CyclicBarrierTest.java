package com.zeroq6.java.corejava.juc;

import java.util.concurrent.CyclicBarrier;

/**
 * CountDownLatch	CyclicBarrier
 * 减计数方式	加计数方式
 * 计算为0时释放所有等待的线程	计数达到指定值时释放所有等待线程
 * 计数为0时，无法重置	计数达到指定值时，计数置为0重新开始
 * 调用countDown()方法计数减一，调用await()方法只进行阻塞，对计数没任何影响	调用await()方法计数加1，若加1后的值不等于构造方法的值，则线程阻塞
 * 不可重复利用	可重复利用
 * ————————————————
 * 版权声明：本文为CSDN博主「tolcf」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/tolcf/java/article/details/50925145
 */
public class CyclicBarrierTest {


    /**
     * https://www.jianshu.com/p/333fd8faa56e
     * @param args
     */
    public static void main(String[] args) {
        int threadNum = 5;
        CyclicBarrier barrier = new CyclicBarrier(threadNum, () -> System.out.println(Thread.currentThread().getName() + " 完成最后任务"));

        for (int i = 0; i < threadNum; i++) {
            new TaskThread(barrier).start();
        }
    }


    static class TaskThread extends Thread {

        private CyclicBarrier barrier;

        public TaskThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(getName() + " 到达栅栏 A");
                barrier.await();
                System.out.println(getName() + " 冲破栅栏 A");

                Thread.sleep(2000);
                System.out.println(getName() + " 到达栅栏 B");
                barrier.await();
                System.out.println(getName() + " 冲破栅栏 B");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

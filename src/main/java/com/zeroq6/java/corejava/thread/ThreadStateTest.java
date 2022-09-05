package com.zeroq6.java.corejava.thread;

import java.util.concurrent.locks.LockSupport;

public class ThreadStateTest {

    public static void main(String[] args) throws Exception{
        thread_state_NEW(); // new
        thread_state_RUNNABLE(); // start
        thread_state_TIMED_WAITING(); // thread.sleep
        thread_state_WAITING(); // LockSupport.park()
        thread_state_BLOCKED(); // synchronized拿不到锁
        thread_state_TERMINATED(); // 执行结束

    }
    public static void thread_state_NEW() {
        Thread thread = new Thread();
        System.out.println(thread.getState());
    }

    public static void thread_state_RUNNABLE() {
        Thread thread = new Thread();
        thread.start();
        System.out.println(thread.getState());
    }

    public static void thread_state_TIMED_WAITING() throws InterruptedException {
        Thread thread3 = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread3.start();
        Thread.sleep(500);
        System.out.println(thread3.getState());
    }

    public static void thread_state_WAITING() throws InterruptedException {
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                LockSupport.park();
            }
        });
        thread2.start();
        Thread.sleep(500);
        System.out.println(thread2.getState());
        LockSupport.unpark(thread2);
    }

    public static void thread_state_BLOCKED() throws InterruptedException {
        final byte[] lock = new byte[0];
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
            }
        });
        thread2.start();
        Thread.sleep(1000);

//        System.out.println(thread1.getState());
        System.out.println(thread2.getState());
    }

    public static void thread_state_TERMINATED() throws InterruptedException {
        Thread thread = new Thread();
        thread.start();
        Thread.sleep(1000);
        System.out.println(thread.getState());
    }
}

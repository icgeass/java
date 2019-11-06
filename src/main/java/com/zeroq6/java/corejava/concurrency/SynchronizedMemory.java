package com.zeroq6.java.corejava.concurrency;

public class SynchronizedMemory {
    static class ReorderExample {
        int a = 0;
        boolean flag = false;

        public void writer() {
            a = 1;

            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
        }

        public void reader() {
            synchronized (this) { // 进入synchronized块会读主内存，进入之后就不会了，所以这里加synchronized无效，需要加到if-flag位置
                while (true) {
                    if (flag) {
                        int i = a * a;
                        System.out.println(i);
                        break;
                    }
                }
                // println方法使用了synchronized，会从主内存读入flag，所以if可以读到flag被线程writer更新的值
                // 注意只会从主内存读入synchronized块作用范围内存的本地变量，比如打印常数123仍然读不到值
//                System.out.println(flag);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ReorderExample reorderExample = new ReorderExample();
        Thread t1 = new Thread(() -> {
            reorderExample.writer();
        });
        Thread t2 = new Thread(() -> {
            reorderExample.reader();
        });
        t2.start();
        t1.start();
        t1.join();
        System.out.println(reorderExample.flag);
        t2.join();

    }
}


package com.zeroq6.java.corejava.juc;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class JucUtils {
    public static void randomSleep() {
        try {
            Thread.sleep(new Random().nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static ExecutorService newFixedThreadPool(int coreSize) {
        return new ThreadPoolExecutor(coreSize, coreSize,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(coreSize));
    }

    public static long currentSeconds(){
        return System.currentTimeMillis() / 1000;
    }
}

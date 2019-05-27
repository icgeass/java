package com.zeroq6.java.learn.corejava.reference;

import java.util.WeakHashMap;

/**
 * @author icgeass
 * @date 2018/7/10
 */
public class TestWeakHashMap {

    public static void main(String[] args) throws Exception{
        WeakHashMap weakHashMap = new WeakHashMap();
        String k1 = "k1";
        weakHashMap.put(k1, "v1");
        System.out.println(weakHashMap.get(k1));
        k1 = null;
        System.gc();
        Thread.sleep(1000L);
        System.out.println(weakHashMap.get(k1));
    }
}

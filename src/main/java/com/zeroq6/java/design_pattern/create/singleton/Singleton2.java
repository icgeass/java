package com.zeroq6.java.design_pattern.create.singleton;


/**
 * 饿加载
 */
public final class Singleton2 {
    private final static Singleton2 INSTANCE = new Singleton2();

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}

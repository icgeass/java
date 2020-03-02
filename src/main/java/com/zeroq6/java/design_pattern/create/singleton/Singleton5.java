package com.zeroq6.java.design_pattern.create.singleton;


/**
 * 枚举,本质上和饿加载一样
 */
public enum Singleton5 {

    INSTANCE;


    public static Singleton5 getInstance() {
        return INSTANCE;
    }
}

package com.zeroq6.java.design_pattern.create.singleton;


/**
 * 使用内部类
 */
public final class Singleton4 {



    private Singleton4(){

    }

    static class Singleton4Holder{
        private static Singleton4 INSTANCE = new Singleton4();
    }


    public static Singleton4 getInstance(){
        return Singleton4Holder.INSTANCE;
    }
}

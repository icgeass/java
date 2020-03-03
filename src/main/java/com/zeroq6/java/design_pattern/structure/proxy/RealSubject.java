package com.zeroq6.java.design_pattern.structure.proxy;

public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println(getClass().getSimpleName() + ".request" );
    }
}

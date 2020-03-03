package com.zeroq6.java.design_pattern.structure.proxy;

public class Proxy implements Subject{

    private Subject subject;
    public Proxy(Subject subject) {
        this.subject = subject;
    }


    @Override
    public void request() {
        System.out.println("before");
        subject.request();
        System.out.println("after");
    }
}

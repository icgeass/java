package com.zeroq6.java.design_pattern.structure.proxy;

public class Client {


    public static void main(String[] args) {
        Proxy proxy = new Proxy(new RealSubject());
        proxy.request();

    }
}

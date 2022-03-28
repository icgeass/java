package com.zeroq6.java.design_pattern.structure.proxy;

/**
 * 代理模式（Proxy）：为其他对象提供一种代理以控制对该对象的访问。
 */
public class Client {


    public static void main(String[] args) {
        Proxy proxy = new Proxy(new RealSubject());
        proxy.request();

    }
}

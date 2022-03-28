package com.zeroq6.java.design_pattern.create.factory.factory_method;

/**
 * 定义一个用于创建对象的接口，让子类决定实例化哪个
 * 类。工厂方法使一个类的实例化延迟到其子类。
 */
public class Client {

    public static void main(String[] args) {
        Factory factory = new FactoryA();
        Product product = factory.build();
        System.out.println(product.getClass().getName());
    }
}

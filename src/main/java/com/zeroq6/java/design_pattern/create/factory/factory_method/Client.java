package com.zeroq6.java.design_pattern.create.factory.factory_method;

public class Client {

    public static void main(String[] args) {
        Factory factory = new FactoryA();
        Product product = factory.build();
        System.out.println(product.getClass().getName());
    }
}

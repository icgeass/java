package com.zeroq6.java.design_pattern.structure.adapter;


/**
 * 将一个类和接口转换为其他类或接相当于一个包装器
 */
public class Client {

    // 将Adaptee适配到Target接口，方法时用Adapter继承Adaptee并且实现Target
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}

package com.zeroq6.java.design_pattern.structure.adapter;


/**
 * 将一个类和接口转换为其他类或接相当于一个包装器
 */
public class Client {


    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}

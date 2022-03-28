package com.zeroq6.java.design_pattern.structure.adapter;


/**
 * 将一个类的接口变换成客户端所期待的另一种接口，从而
 * 使原本因接口不匹配而无法在一起工作的两个类能够在一起工作。
 *
 * 将一个类和接口转换为其他类或接口，相当于一个包装器
 */
public class Client {

    // 将Adaptee适配到Target接口，方法是用Adapter继承Adaptee并且实现Target
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}

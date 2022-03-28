package com.zeroq6.java.design_pattern.structure.flyweight;

/**
 * 享元模式（Flyweight）：是池技术的重要实现方式，使用共享对象可有效地支持大量的细粒度的对象。
 */
public class Client {

    public static void main(String[] args) {
        Flyweight flyweight1 = FlyweightFactory.getFlyweight("1");
        Flyweight flyweight2 = FlyweightFactory.getFlyweight("2");
        Flyweight flyweight3 = FlyweightFactory.getFlyweight("1");
        System.out.println(flyweight1);
        System.out.println(flyweight2);
        System.out.println(flyweight3);
        System.out.println("------------------");
        flyweight1.operation("a");
        flyweight2.operation("b");
        flyweight3.operation("c");
        flyweight3.operation("x");

    }
}

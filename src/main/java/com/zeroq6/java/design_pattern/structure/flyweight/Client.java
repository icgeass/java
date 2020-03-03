package com.zeroq6.java.design_pattern.structure.flyweight;

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

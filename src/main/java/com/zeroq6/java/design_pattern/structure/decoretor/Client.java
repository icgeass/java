package com.zeroq6.java.design_pattern.structure.decoretor;

public class Client {
    public static void main(String[] args) {
        Decorator2 decorator2 = new Decorator2(new Decorator1(new ConcreteComponent()));
        decorator2.operate();
    }
}

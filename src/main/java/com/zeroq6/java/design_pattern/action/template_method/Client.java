package com.zeroq6.java.design_pattern.action.template_method;

public class Client {
    public static void main(String[] args) {
        AbstractClass ac = new ConcreteClass();
        //调用模板方法
        ac.templateMethod();
    }
}

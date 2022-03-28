package com.zeroq6.java.design_pattern.action.template_method;

/**
 * 定义一个操作中的算法的框架，而将一些步骤延迟到子类
 * 中。使得子类可以不改变一个算法的结构即可重定义该算法的某些特定
 * 步骤。
 */
public class Client {
    public static void main(String[] args) {
        AbstractClass ac = new ConcreteClass();
        //调用模板方法
        ac.templateMethod();
    }
}

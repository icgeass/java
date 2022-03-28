package com.zeroq6.java.design_pattern.action.observer;

/**
 *
 * 定义对象间一种一对多的依赖关系，使得每当一个对象改
 * 变状态，则所有依赖于它的对象都会得到通知并被自动更新。
 *
 * 参考
 * https://github.com/iluwatar/java-design-patterns/tree/master/observer
 * <p>
 * 主题,一般是环境信息或者叫做被观察者
 */
public class Client {


    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject("主题1");
        concreteSubject.addObserver(new ConcreteObserver("观察者1"));
        concreteSubject.addObserver(new ConcreteObserver("观察者2"));
        concreteSubject.addObserver(new ConcreteObserver("观察者3"));
        concreteSubject.somethingChanged("message");

    }
}

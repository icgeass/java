package com.zeroq6.java.design_pattern.action.observer;

/**
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

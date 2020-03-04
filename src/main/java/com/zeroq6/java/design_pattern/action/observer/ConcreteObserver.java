package com.zeroq6.java.design_pattern.action.observer;

public class ConcreteObserver implements Observer<ConcreteSubject, ConcreteObserver, String>{


    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(ConcreteSubject subject, String argument) {
        System.out.println(name + " receive " + argument);
    }
}

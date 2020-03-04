package com.zeroq6.java.design_pattern.action.observer;


public class ConcreteSubject extends AbstractSubject<ConcreteSubject, ConcreteObserver, String> {

    public ConcreteSubject(String name) {
        super(name);
    }

    public void somethingChanged(String argument){
        System.out.println(name + " send " + argument);
        notifyObservers(argument);
    }
}

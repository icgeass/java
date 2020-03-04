package com.zeroq6.java.design_pattern.action.visitor;

public class ConcreteElement1 extends Element {

    public ConcreteElement1(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.accept(this);
    }


    public void specialMethod1(){
        System.out.println("specialMethod1");
    }
}

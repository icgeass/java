package com.zeroq6.java.design_pattern.action.visitor;

public class ConcreteElement2 extends Element {

    public ConcreteElement2(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.accept(this);
    }

    public void specialMethod2(){
        System.out.println("specialMethod2");
    }
}

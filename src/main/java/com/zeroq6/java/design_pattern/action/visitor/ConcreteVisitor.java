package com.zeroq6.java.design_pattern.action.visitor;

public class ConcreteVisitor implements Visitor {

    @Override
    public void accept(ConcreteElement1 concreteElement1) {
        System.out.println("ConcreteVisitor visit " + concreteElement1.getName());
        concreteElement1.specialMethod1();
    }

    @Override
    public void accept(ConcreteElement2 concreteElement2) {
        System.out.println("ConcreteVisitor visit ConcreteElement2" + concreteElement2.getName());
        concreteElement2.specialMethod2();
    }
}

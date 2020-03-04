package com.zeroq6.java.design_pattern.action.visitor;

public abstract class Element {

    protected String name;

    public Element(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void accept(Visitor visitor);
}

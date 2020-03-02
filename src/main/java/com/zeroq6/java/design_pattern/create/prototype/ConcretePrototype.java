package com.zeroq6.java.design_pattern.create.prototype;

public class ConcretePrototype implements Prototype{

    private String name;


    public ConcretePrototype(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Prototype cloneInstance(){
        return new ConcretePrototype(this.getName());
    }
}

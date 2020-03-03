package com.zeroq6.java.design_pattern.structure.decoretor;

public class ConcreteComponent implements Component {

    @Override
    public void operate() {
        System.out.println("ConcreteComponent operate");
    }
}

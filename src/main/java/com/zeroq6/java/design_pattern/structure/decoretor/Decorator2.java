package com.zeroq6.java.design_pattern.structure.decoretor;

public class Decorator2 implements Component {

    private Component component;

    public Decorator2(Component component) {
        this.component = component;
    }

    @Override
    public void operate() {
        System.out.println("Decorator2 operate");
        component.operate();
    }
}

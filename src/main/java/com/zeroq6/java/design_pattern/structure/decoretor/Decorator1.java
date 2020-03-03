package com.zeroq6.java.design_pattern.structure.decoretor;

public class Decorator1  implements Component {

    private Component component;

    public Decorator1(Component component) {
        this.component = component;
    }

    @Override
    public void operate() {
        System.out.println("Decorator1 operate");
        component.operate();
    }
}

package com.zeroq6.java.design_pattern.structure.flyweight;

public class ConcreteFlyweight implements Flyweight {
    private String intrinsicState;// 内部状态

    ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String extrinsicState) {
        System.out.println("内部状态：" + intrinsicState
                + "，外部状态：" + extrinsicState);
    }
}

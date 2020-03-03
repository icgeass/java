package com.zeroq6.java.design_pattern.action.strategy;

public class StrategySub implements Strategy {

    @Override
    public int operate(int op1, int op2) {
        return op1 - op2;
    }
}

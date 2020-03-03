package com.zeroq6.java.design_pattern.action.strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int execute(int num1, int num2){
        return strategy.operate(num1, num2);
    }


}

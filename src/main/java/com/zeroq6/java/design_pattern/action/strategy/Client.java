package com.zeroq6.java.design_pattern.action.strategy;

public class Client {

    public static void main(String[] args) {
        Context context = new Context(new StrategyPlus());
        int result = context.execute(100, 50);
        System.out.println(result);
        System.out.println("-----------------");
        context.setStrategy(new StrategySub());
        result = context.execute(100, 50);
        System.out.println(result);
    }
}

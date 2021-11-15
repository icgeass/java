package com.zeroq6.java.design_pattern.action.interpreter;

/**
 * icgeass@hotmail.com
 * 2021/11/15 9:01 下午
 */
public class TerminalExpression implements Expression{
    private int value;

    public TerminalExpression(int value){
        this.value = value;
    }

    @Override
    public double interpret() {
        return value;
    }
}

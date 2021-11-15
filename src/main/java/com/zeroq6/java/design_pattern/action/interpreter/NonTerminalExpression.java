package com.zeroq6.java.design_pattern.action.interpreter;

/**
 * icgeass@hotmail.com
 * 2021/11/15 9:01 下午
 */
public abstract class NonTerminalExpression implements Expression{

    protected Expression left;
    protected Expression right;

    public NonTerminalExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}

package com.zeroq6.java.design_pattern.action.interpreter;

/**
 * icgeass@hotmail.com
 * 2021/11/15 9:02 下午
 */
public class DivExpression extends NonTerminalExpression{
    public DivExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double interpret() {
        return this.left.interpret() / this.right.interpret();
    }
}

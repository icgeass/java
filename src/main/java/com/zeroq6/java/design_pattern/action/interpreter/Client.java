package com.zeroq6.java.design_pattern.action.interpreter;

/**
 * icgeass@hotmail.com
 * 2021/11/15 8:56 下午
 *
 * 给定一门语言，定义它的文法的一种表示，并定义一个解释器，该解释器使用该表示来解释语言中的句子
 */
public class Client {
    // 终结符是叶子节点，不用计算直接返回值。非终结符需要解释计算左右操作符
    public static void main(String[] args) {
        double result = new DivExpression(new MultiExpression(new SubExpression(new TerminalExpression(8), new TerminalExpression(3)), new TerminalExpression(4)), new PlusExpression(new TerminalExpression(1), new TerminalExpression(9))).interpret();
        System.out.println(result);
        System.out.println(((8 - 3) * 4) / (1 + 9));
    }
}

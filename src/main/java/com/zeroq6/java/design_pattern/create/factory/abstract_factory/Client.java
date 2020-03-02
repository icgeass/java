package com.zeroq6.java.design_pattern.create.factory.abstract_factory;


/**
 * factory生产的不是最终产品,而是组成最终产品的部件
 * 最终产品根据不同的部件组成了不同的类型产品,如戴尔鼠标键盘的计算器或者惠普鼠标键盘的电脑
 */
public class Client {
    public static void main(String[] args) {
        Factory factory = new FactoryProductA();
        // 戴尔鼠标
        Part1 part1 = factory.getProductPart1();
        // 戴尔键盘
        Part2 part2 = factory.getProductPart2();
        System.out.println(part1);
        System.out.println(part2);
    }
}

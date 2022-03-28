package com.zeroq6.java.design_pattern.create.factory.abstract_factory;


/**
 * 为创建一组相关或相互依赖的对象提供一个接口，而且无
 * 须指定它们的具体类。
 *
 * factory生产的不是最终产品,而是组成最终产品的部件
 * 最终产品根据不同的部件组成了不同的类型产品,如戴尔鼠标键盘的计算器或者惠普鼠标键盘的电脑
 * 如果一个产品只有一个部件（方法），则这个部件就是一个产品，就和工厂方法一样了
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

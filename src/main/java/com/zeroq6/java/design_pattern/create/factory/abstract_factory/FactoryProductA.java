package com.zeroq6.java.design_pattern.create.factory.abstract_factory;

public class FactoryProductA implements Factory{

    @Override
    public Part1 getProductPart1() {
        return new ProductAPart1();
    }

    @Override
    public Part2 getProductPart2() {
        return new ProductAPart2();
    }
}

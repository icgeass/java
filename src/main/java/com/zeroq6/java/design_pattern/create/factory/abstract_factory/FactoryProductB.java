package com.zeroq6.java.design_pattern.create.factory.abstract_factory;

public class FactoryProductB implements Factory {

    @Override
    public Part1 getProductPart1() {
        return new ProductBPart1();
    }

    @Override
    public Part2 getProductPart2() {
        return new ProductBPart2();
    }
}

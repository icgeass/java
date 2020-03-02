package com.zeroq6.java.design_pattern.create.factory.factory_method;

public class FactoryA implements Factory {
    @Override
    public Product build() {
        return new ProductA();
    }
}

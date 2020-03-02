package com.zeroq6.java.design_pattern.create.factory.factory_method;

public class FactoryB implements Factory {
    @Override
    public Product build() {
        return new ProductB();
    }
}

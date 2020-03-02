package com.zeroq6.java.design_pattern.create.builder;

public class ConcreteBuilder extends Builder {


    public ConcreteBuilder() {
        product = new Product();
    }

    @Override
    public Builder setPart1(String name) {
        product.setPart1(name);
        return this;

    }

    @Override
    public Builder setPart2(String name) {
        product.setPart2(name);
        return this;

    }

    @Override
    public Product build() {
        return product;
    }
}

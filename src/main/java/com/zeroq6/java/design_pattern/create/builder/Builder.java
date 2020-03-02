package com.zeroq6.java.design_pattern.create.builder;

public abstract class Builder {

    protected Product product;
    public abstract Builder setPart1(String name);
    public abstract Builder setPart2(String name);
    public abstract Product build();

}

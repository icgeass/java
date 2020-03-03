package com.zeroq6.java.design_pattern.structure.adapter;


public class Adapter extends Adaptee implements Target{

    @Override
    public void request() {
        super.specificRequest();
    }
}

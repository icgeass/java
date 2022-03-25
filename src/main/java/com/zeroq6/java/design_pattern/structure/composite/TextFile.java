package com.zeroq6.java.design_pattern.structure.composite;

public class TextFile extends File{
    public TextFile(String name) {
        super(name);
    }

    @Override
    public boolean isFile() {
        return true;
    }


    @Override
    public void display() {
        System.out.println("-TextFile: " + this.name);
    }
}

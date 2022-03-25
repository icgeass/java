package com.zeroq6.java.design_pattern.structure.composite;

import java.util.List;

public abstract class File {

    protected String name;

    public File(String name) {
        this.name = name;
    }

    public abstract void display();

    public abstract boolean isFile();

    public List<File> getChildren() {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        return this.name;
    }

    public void add(File file) {
        throw new UnsupportedOperationException();
    }

    public void remove(File file) {
        throw new UnsupportedOperationException();
    }
}

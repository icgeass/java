package com.zeroq6.java.design_pattern.structure.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class File {

    protected String name;

    public File(String name) {
        this.name = name;
    }

    public abstract void display();

    public abstract boolean isFile();

    public List<File> getChildren(){
        return new ArrayList<>();
    }

    public void add(File file){

    }

    public void remove(File file){

    }
}

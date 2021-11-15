package com.zeroq6.java.design_pattern.structure.composite;

import java.util.ArrayList;
import java.util.List;

public class Folder extends File{
    private List<File> children = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println(">>>Folder: " + this.name);
        for(File file : children){
            file.display();
        }
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public List<File> getChildren() {
        return children;
    }

    @Override
    public void add(File file) {
        children.add(file);
    }

    @Override
    public void remove(File file) {
        children.remove(file);
    }
}

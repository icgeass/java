package com.zeroq6.java.design_pattern.structure.composite;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Folder extends File {


    private List<File> children = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    @Override
    public void display() {
        display(this, 0);
    }

    private void display(File f, int depth) {
        System.out.println(StringUtils.repeat(" ", depth) + "=Folder: " + f.getName());
        depth++;
        for (File file : f.getChildren()) {
            if (file.isFile()) {
                System.out.print(StringUtils.repeat(" ", depth));
                file.display();
            } else {
                ((Folder) file).display(file, depth);
            }
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

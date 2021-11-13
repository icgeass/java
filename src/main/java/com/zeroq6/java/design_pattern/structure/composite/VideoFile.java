package com.zeroq6.java.design_pattern.structure.composite;

public class VideoFile extends File{
    public VideoFile(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println(">VideoFile: " + this.name);
    }
}

package com.zeroq6.java.learn.corejava.clone;

import java.io.Serializable;

/**
 * @author
 * @date 2018/7/10
 */
public class ClassB implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private ClassC classC;

    public String getName() {
        return name;
    }

    public ClassB setName(String name) {
        this.name = name;
        return this;
    }

    public ClassC getClassC() {
        return classC;
    }

    public ClassB setClassC(ClassC classC) {
        this.classC = classC;
        return this;
    }
}

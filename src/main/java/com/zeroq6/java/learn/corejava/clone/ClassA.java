package com.zeroq6.java.learn.corejava.clone;

import java.io.Serializable;

/**
 * @author
 * @date 2018/7/10
 */
public class ClassA implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private ClassB classB;

    public Integer getId() {
        return id;
    }

    public ClassA setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ClassA setName(String name) {
        this.name = name;
        return this;
    }

    public ClassB getClassB() {
        return classB;
    }

    public ClassA setClassB(ClassB classB) {
        this.classB = classB;
        return this;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

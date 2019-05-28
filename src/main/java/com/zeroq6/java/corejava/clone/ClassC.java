package com.zeroq6.java.corejava.clone;

import java.io.Serializable;

/**
 * @author
 * @date 2018/7/10
 */
public class ClassC implements Serializable {

    private static final long serialVersionUID = 1L;


    private String name;


    public String getName() {
        return name;
    }

    public ClassC setName(String name) {
        this.name = name;
        return this;
    }
}

package com.zeroq6.java.design_pattern.structure.composite;

import java.util.List;
import java.util.Objects;

public abstract class Component {

    protected String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void operate();

    public void add(Component component) {
        System.out.println("不支持add");
    }

    public void remove(Component component) {
        System.out.println("不支持remove");
    }

    public List<Component> getChildren() {
        System.out.println("不支持getChildren");
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Component component = (Component) o;
        return Objects.equals(name, component.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

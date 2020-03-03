package com.zeroq6.java.design_pattern.structure.composite;


import java.util.ArrayList;
import java.util.List;

/**
 * 合成的,包含子节点的
 */
public class Composite extends Component {


    private List<Component> list = new ArrayList<>();


    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void operate() {
        System.out.println("Composite operate " + this.name);

    }

    @Override
    public void add(Component component) {
        System.out.println("add " + component.getName());
        list.add(component);
    }

    @Override
    public void remove(Component component) {
        System.out.println("remove " + component.getName());
        list.remove(component);
    }

    @Override
    public List<Component> getChildren() {
        return list;
    }
}

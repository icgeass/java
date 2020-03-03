package com.zeroq6.java.design_pattern.structure.composite;

public class Leaf extends Component {


    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operate() {
        System.out.println("Leaf operate " + this.name);
    }
}

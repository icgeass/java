package com.zeroq6.java.design_pattern.action.visitor;

import java.util.ArrayList;
import java.util.List;

public class ObjectStruct {
    private List<Element> list = new ArrayList<>();

    public void addElement(Element element){
        list.add(element);
    }

    public void removeElement(Element element){
        list.remove(element);
    }

    public void accept(Visitor visitor){
        for(Element e: list){
            e.accept(visitor);
        }
    }
}

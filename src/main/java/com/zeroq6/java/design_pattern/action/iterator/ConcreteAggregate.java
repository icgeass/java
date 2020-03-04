package com.zeroq6.java.design_pattern.action.iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregate implements Aggregate {
    private List list = new ArrayList();
    public void add(Object object) {
        list.add(object);
    }
    public Object getElement(int index) {
        if (index < list.size()) {
            return list.get(index);
        } else {
            return null;
        }
    }
    public int size() {
        return list.size();
    }
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }
}
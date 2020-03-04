package com.zeroq6.java.design_pattern.action.memento;


import java.util.ArrayList;
import java.util.List;

/**
 * 看管人
 */
public class Caretaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }
}

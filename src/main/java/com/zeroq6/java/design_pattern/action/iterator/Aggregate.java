package com.zeroq6.java.design_pattern.action.iterator;

public interface Aggregate {
    void add(Object obj);
    Iterator createIterator();
}
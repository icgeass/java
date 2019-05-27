package com.zeroq6.java.learn.algorithm.stack;


public class Stack<E> {

    private Object[] elements;

    private int size = 0;

    private final static int DEFAULT_SIZE = 16;
    
    public Stack() {
        this(DEFAULT_SIZE);
    }

    public Stack(int size) {
        if (size <= 0) {
            size = DEFAULT_SIZE;
        }
        this.elements = new Object[size];
    }
    
    public E peek() {
        if (!isEmpty()) {
            return (E)elements[size - 1];
        }
        return null;
    }

    public E pop() {
        E result = null;
        if (!isEmpty()) {
            result = (E)elements[size - 1];
            size--;
        }
        return result;
    }

    public boolean push(E element) {
        boolean result = false;
        if (size == elements.length) {
            throw new RuntimeException("超过最大容量，" + size);
        } else {
            size++;
            elements[size - 1] = element;
            result = true;
        }
        return result;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

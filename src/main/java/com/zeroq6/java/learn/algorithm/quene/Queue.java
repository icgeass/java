package com.zeroq6.java.learn.algorithm.quene;

public class Queue<E> {

    private Object[] elements;

    private int size = 0;

    private final static int DEFAULT_SIZE = 16;

    public Queue() {
        this(DEFAULT_SIZE);
    }

    public Queue(int size) {
        if (size <= 0) {
            size = DEFAULT_SIZE;
        }
        this.elements = new Object[size];
    }

    public E removeFirst() {
        E e = null;
        if (size == 0) {
            throw new RuntimeException("队列为空");
        }
        e = (E) elements[0];
        for (int i = 0; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return e;
    }

    public E addLast(E element) {
        E e = null;
        if (size == elements.length) {
            throw new RuntimeException("队列超过最大容量，" + size);
        }
        size++;
        elements[size - 1] = element;
        return e;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


}

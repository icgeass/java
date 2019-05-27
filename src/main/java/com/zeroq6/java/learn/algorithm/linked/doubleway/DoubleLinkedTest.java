package com.zeroq6.java.learn.algorithm.linked.doubleway;

public class DoubleLinkedTest {

    public static void main(String[] args) {
        DoubleLinked<String> doubleLinked = new DoubleLinked<String>();
        doubleLinked.addFirst("1");
        doubleLinked.addLast("2");
        doubleLinked.indexOf("1");
        doubleLinked.addLast("3");
        doubleLinked.add(2, "4");
        doubleLinked.removeFirst();
        doubleLinked.remove("3");
        doubleLinked.removeLast();
        System.out.println();
    }
}

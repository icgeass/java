package com.zeroq6.java.data_structure.linked.oneway;

public class SingleLinkedTest {

    public static void main(String[] args) {
        SingleLinked<String> singleLinked = new SingleLinked<String>();
        singleLinked.addFirst("1");
        singleLinked.addLast("2");
        singleLinked.indexOf("1");
        singleLinked.addLast("3");
        singleLinked.add(2, "4");
        singleLinked.removeFirst();
        singleLinked.remove("3");
        singleLinked.removeLast();
        System.out.println();
    }
}

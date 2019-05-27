package com.zeroq6.java.learn.algorithm.linked.doubleway;

public class DoubleLinked<E> {

    private Node<E> head;

    private Node<E> tail;

    private int size;

    public void addFirst(E e) {
        Node<E> newNode = new Node<E>(null, e, null);
        if (null == head) {
            head = newNode;
            tail = head;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<E>(null, e, null);
        if (null == head) {
            head = newNode;
            tail = head;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public void add(int index, E e) {
        checkIndex(index);
        if (index == 0) {
            addFirst(e);
        } else if (index == size - 1) {
            addLast(e);
        } else {
            Node<E> newNode = new Node<E>(null, e, null);
            Node<E> curr = getNode(index);
            Node<E> prev = getNode(index - 1);
            newNode.setNext(curr);
            newNode.setPrev(prev);
            curr.setPrev(newNode);
            prev.setNext(newNode);
            size++;
        }
    }

    public void removeLast() {
        if (size == 0) {
            return;
        } else if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node<E> node = tail.getPrev();
            node.setNext(null);
            //
            tail.setPrev(null);
            tail = node;
        }
        size--;
    }

    public void removeFirst() {
        if (size == 0) {
            return;
        } else if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node<E> node = head.getNext();
            node.setPrev(null);
            //
            head.setNext(null);
            head = node;
        }
        size--;
    }

    public void remove(int index){
        checkIndex(index);
        if(index == 0){
            removeFirst();
        }else if(index == size - 1){
            removeLast();
        }else{
            Node<E> curr = getNode(index);
            Node<E> prev = getNode(index - 1);
            Node<E> next = getNode(index + 1);
            curr.setNext(null);
            curr.setPrev(null);
            next.setPrev(prev);
            prev.setNext(next);
            size--;
        }

    }

    public void remove(E e){
        int index = indexOf(e);
        if(index != -1){
            remove(index);
        }

    }


    public int indexOf(E e) {
        int index = -1;
        if (null == e) {
            for (Node<E> node = head; head != null && node != null; node = node.getNext()) {
                index++;
                if (e == node.getData()) {
                    return index;
                }
            }
        } else {
            for (Node<E> node = head; head != null && node != null; node = node.getNext()) {
                if (e.equals(node.getData())) {
                    return index;
                }
            }
        }
        return index;
    }


    private Node<E> getNode(int index) {
        checkIndex(index);

        Node<E> re = null;
        int i = -1;
        for (Node<E> node = head; head != null && node != null; node = node.getNext()) {
            i++;
            if (i == index) {
                re = node;
                break;
            }
        }
        return re;
    }

    private void checkIndex(int index) {
        if (index < 0 || index + 1 > size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }

}

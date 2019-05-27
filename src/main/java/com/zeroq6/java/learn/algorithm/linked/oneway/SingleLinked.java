package com.zeroq6.java.learn.algorithm.linked.oneway;


public class SingleLinked<E> {

    private Node<E> head;

    private Node<E> tail;

    private int size;


    public void addFirst(E e){
        Node<E> newNode = new Node<E>(e, null);
        if(head == null){
            head = newNode;
            tail = head;
        }else{
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }


    public void addLast(E e){
        Node<E> newNode = new Node<E>(e, null);
        if(head == null){
            head = newNode;
            tail = head;
        }else{
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }



    public void add(int index, E e) {
        checkIndex(index);
        if(index == 0){
            addFirst(e);
        }else if(index == size -1){
            addLast(e);
        }else{
            Node<E> newNode = new Node<E>(e, null);
            Node<E> prev = getNode(index - 1);
            Node<E> curr = getNode(index);
            prev.setNext(newNode);
            newNode.setNext(curr);
            size++;
        }

    }

    public void removeFirst(){
        if(size <= 0){
            return;
        }else if(size == 1){
            head = null;
            tail = null;
        }else{
            Node<E> h = head;
            head = head.getNext();
            h.setNext(null);
        }
        size--;

    }

    public void removeLast(){
        if(size <= 0){
            return;
        }else if(size == 1){
            head = null;
            tail = null;
        }else{
            Node<E> node = getNode(size - 2);
            node.setNext(null);
            tail = node;
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
            prev.setNext(next);
            curr.setNext(null);
            size--;
        }

    }

    public void remove(E e){
        int index = indexOf(e);
        if(index != -1){
            remove(index);
        }

    }

    public int size(){
        return size;
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
                index++;
                if (e.equals(node.getData())) {
                    return index;
                }
            }
        }
        return index;
    }

    public E get(int index){
        E re = null;
        Node<E> node = getNode(index);
        if(null != node){
            re = node.getData();
        }
        return re;
    }

    private Node<E> getNode(int index){
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

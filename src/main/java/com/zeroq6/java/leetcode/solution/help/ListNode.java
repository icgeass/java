package com.zeroq6.java.leetcode.solution.help;

/**
 * Definition for singly-linked list.
 */
public class ListNode {


    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public static ListNode genListNode(int... arr) {
        if (null == arr || arr.length == 0) {
            return null;
        }
        ListNode re = new ListNode(arr[0]);
        ListNode tmp = re;
        for (int i = 1; i < arr.length; i++) {
            tmp.next = new ListNode(arr[i]);
            tmp = tmp.next;
        }
        return re;
    }

    public static void printListNode(ListNode result){
        ListNode tmp = result;
        StringBuilder stringBuilder = new StringBuilder("[");
        while (null != tmp) {
            stringBuilder.append(tmp.val).append(",");
            tmp = tmp.next;
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1).append("]");
        System.out.println(stringBuilder.toString());
    }
}


package com.zeroq6.java.leetcode.solution;


/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
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
}

public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = l1.val;
        int b = l2.val;
        int sum = 0;
        ListNode result = null;

        ListNode tmp = l1;
        while ((tmp = tmp.next) != null) {
            a = a * 10 + tmp.val;
        }
        tmp = l2;
        while ((tmp = tmp.next) != null) {
            b = b * 10 + tmp.val;
        }
        sum = a + b;

        //
        result = new ListNode(sum % 10); // 取最后一位
        tmp = result;
        while ((sum = sum / 10) != 0) { // 当sum为个位数时, sum/10=0, 这个个位数在上一次中已经添加
            tmp.next = new ListNode(sum % 10);
            tmp = tmp.next;
        }
        return result;

    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);


        Object result = new Solution2().addTwoNumbers(l1, l2);

        System.out.println(JSON.toJSONString(result, SerializerFeature.PrettyFormat));


    }
}


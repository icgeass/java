package com.zeroq6.java.leetcode.solution;


import com.zeroq6.java.leetcode.solution.help.ListNode;


/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * <p>
 * <p>
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Solution21 {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode point = null;

        // 
        ListNode point1 = l1;
        ListNode point2 = l2;
        while (true) {
            if (point1 == null && point2 == null) {
                break;
            }

            // 添加point2
            if (point1 == null) {
                while (point2 != null) {
                    if (null == result) {
                        result = new ListNode(point2.val);
                        point = result;
                    } else {
                        point.next = new ListNode(point2.val);
                        point = point.next;
                    }
                    point2 = point2.next;

                }
                break;
            }


            // 添加point1
            if (point2 == null) {
                while (point1 != null) {
                    if (null == result) {
                        result = new ListNode(point1.val);
                        point = result;
                    } else {
                        point.next = new ListNode(point1.val);
                        point = point.next;
                    }
                    point1 = point1.next;

                }
                break;
            }


            // point1.val小,添加point1.val并移动point1
            if (point1.val < point2.val) {
                if (null == result) {
                    result = new ListNode(point1.val);
                    point = result;
                } else {
                    point.next = new ListNode(point1.val);
                    point = point.next;
                }
                point1 = point1.next;

            } else {
                if (null == result) {
                    result = new ListNode(point2.val);
                    point = result;
                } else {
                    point.next = new ListNode(point2.val);
                    point = point.next;
                }
                point2 = point2.next;
            }


        }


        return result;
    }


    public static void main(String[] args) {
        ListNode.printListNode(new Solution21().mergeTwoLists(ListNode.genListNode(1, 2, 4), ListNode.genListNode(1, 3, 4)));
        ListNode.printListNode(new Solution21().mergeTwoLists(ListNode.genListNode(), ListNode.genListNode(1, 3, 4)));
        ListNode.printListNode(new Solution21().mergeTwoLists(ListNode.genListNode(1, 3, 6, 9), ListNode.genListNode(6)));
        ListNode.printListNode(new Solution21().mergeTwoLists(ListNode.genListNode(3, 6, 9), ListNode.genListNode()));


    }


}

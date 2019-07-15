package com.zeroq6.java.leetcode.solution.alibaba;


import com.zeroq6.java.leetcode.solution.help.ListNode;

/**
 * https://github.com/icgeass/interview_internal_reference
 * <p>
 * <p>
 * 问题：如何实现一个高效的单向链表逆序输出？
 * 出题人：阿里巴巴出题专家：昀龙／阿里云弹性人工智能负责人
 */
public class Solution1 {

    public void printListNode(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        if (listNode.next != null) {
            printListNode(listNode.next);
        }
        System.out.print(listNode.val + ",");
    }

    public static void main(String[] args) {
        new Solution1().printListNode(ListNode.genListNode(1, 2, 3, 4, 5, 6));
    }
}

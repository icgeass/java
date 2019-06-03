package com.zeroq6.java.leetcode.solution;


import com.zeroq6.java.leetcode.solution.help.ListNode;

/**
 * 19. 删除链表的倒数第N个节点
 * <p>
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * <p>
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }
        ListNode targetPrev = null;
        ListNode target = head;

        ListNode tmp = head;

        // 假设倒数第n个点就是第一个点,则n为0时,tmp.next = null;
        while (tmp != null) {
            n--;
            if (n == 0) {
                if (tmp.next == null) { // 说明假设成立
                    // 删除target节点
                    if (targetPrev != null) {
                        targetPrev.next = target.next;
                    }
                    break;
                } else {
                    n++;
                    // 上一次假设错误,重新假定上一次假定的下一个点
                    targetPrev = target;
                    target = target.next;
                }

            }
            tmp = tmp.next;


        }
        return targetPrev == null ? head.next : head;
    }


    public static void main(String[] args) {
        System.out.println(new Solution19().removeNthFromEnd(ListNode.genListNode(null), 4));
        System.out.println(new Solution19().removeNthFromEnd(ListNode.genListNode(1), 1));
        System.out.println(new Solution19().removeNthFromEnd(ListNode.genListNode(1, 2, 3, 4, 5), 2));
        System.out.println(new Solution19().removeNthFromEnd(ListNode.genListNode(1, 2, 3, 4, 5), 5));
        System.out.println(new Solution19().removeNthFromEnd(ListNode.genListNode(1, 2, 3, 4, 5), 1));


    }


}

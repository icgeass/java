package com.zeroq6.java.leetcode.solution;


import com.zeroq6.java.leetcode.solution.help.ListNode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = head;

        while (null != head) {
            if (null == head.next) {
                break; // head指向倒数第一个
            }
            if (head.val == head.next.val) {
                if (head.next.next == null) { // head 指向倒数第二个
                    head.next = null;
                } else {
                    head.next = head.next.next; // 去掉head.next节点
                    continue;
                }
            }


            head = head.next;
        }
        return result;
    }


    public static void main(String[] args) {
        ListNode.printListNode(new Solution83().deleteDuplicates(ListNode.genListNode(1, 1, 2)));

        ListNode.printListNode(new Solution83().deleteDuplicates(ListNode.genListNode(1, 1, 2, 3, 3)));

        ListNode.printListNode(new Solution83().deleteDuplicates(ListNode.genListNode(1, 1, 1)));



    }
}

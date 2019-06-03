package com.zeroq6.java.leetcode.solution;


import com.zeroq6.java.leetcode.solution.help.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * <p>
 * <p>
 * 23. 合并K个排序链表
 * <p>
 * <p>
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Solution23 {

    //
    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        List<Integer> integerList = new ArrayList<>();
        ListNode tmp;
        // 取出
        ListNode result = null;
        for (int i = 0; i < lists.length; i++) {
            tmp = lists[i];
            if (null == tmp) {
                continue;
            }
            integerList.add(tmp.val);
            while (tmp.next != null) {
                tmp = tmp.next;
                integerList.add(tmp.val);
            }
        }
        tmp = null;

        // 排序
        Collections.sort(integerList);

        // 添加
        for (int i = 0; i < integerList.size(); i++) {
            if (null == result) {
                result = new ListNode(integerList.get(i));
                tmp = result;
            } else {
                tmp.next = new ListNode(integerList.get(i));
                tmp = tmp.next;
            }
        }
        return result;

    }


    public static void main(String[] args) {
        ListNode.printListNode(new Solution23().mergeKLists(new ListNode[]{ListNode.genListNode(1, 4, 5),
                ListNode.genListNode(1, 3, 4), ListNode.genListNode(2, 6)}));

        ListNode.printListNode(new Solution23().mergeKLists(new ListNode[]{null,
                ListNode.genListNode(5), ListNode.genListNode(9, 7, 0, 3)}));

        ListNode.printListNode(new Solution23().mergeKLists(new ListNode[]{}));


    }

}

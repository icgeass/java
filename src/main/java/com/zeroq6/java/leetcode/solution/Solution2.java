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
 * 这个例子中:342 + 465 = 807  而243 + 564 = 807 ,比较混淆
 * <p>
 * 第一次错误:没有理解逆序, (2 -> 4 -> 3)表示 342而不是243
 * 输入：
 * [1,8]
 * [0]
 * 输出：
 * [8,1]
 * 预期：
 * [1,8]
 * <p>
 * 第二次错误:int越界
 * 输入：
 * [9]
 * [1,9,9,9,9,9,9,9,9,9]
 * 输出：
 * [8,0,4,5,6,0,0,1,4,1]
 * 预期：
 * [0,0,0,0,0,0,0,0,0,0,1]
 * <p>
 * 改成long不可取,同样有越界的可能
 * 所以用链表从左至右对位相加进位方式构造链表
 *
 */


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
        ListNode result = null;

        ListNode tmp1 = l1;
        ListNode tmp2 = l2;

        ListNode tmp = null; // 结果指针

        int nextAdd = 0; // 保存本次进位到下一次累加结果,为1或者0

        while (null != tmp1 || null != tmp2) {

            int sum = (null == tmp1 ? 0 : tmp1.val) + (null == tmp2 ? 0 : tmp2.val) + nextAdd;
            if (null == result) {
                tmp = new ListNode(sum % 10);  // 取个位
                result = tmp;
            } else {
                tmp.next = new ListNode(sum % 10);  // 取个位
                tmp = tmp.next;
            }
            nextAdd = sum / 10; // 取进位

            tmp1 = null != tmp1 ? tmp1.next : null;
            tmp2 = null != tmp2 ? tmp2.next : null;
        }
        if (nextAdd != 0) {
            tmp.next = new ListNode(nextAdd);
        }


        return result;

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


    public static void main(String[] args) {
        ListNode l1 = genListNode(9);

        ListNode l2 = genListNode(1, 9, 9, 9, 9, 9, 9, 9, 9, 9);


        ListNode result = new Solution2().addTwoNumbers(l1, l2);

        ListNode tmp = result;
        StringBuilder stringBuilder = new StringBuilder("[");
        while (null != tmp) {
            stringBuilder.append(tmp.val).append(",");
            tmp = tmp.next;
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1).append("]");
        System.out.println(stringBuilder.toString());


        System.out.println(Integer.MAX_VALUE);


    }
}


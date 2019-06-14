package com.zeroq6.java.leetcode.solution;


import com.zeroq6.java.leetcode.solution.help.ListNode;
import com.zeroq6.java.leetcode.solution.help.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:      1          1
 * /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * 输出: false
 * 示例 3:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * <p>
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 写树算法的套路框架
 * labuladong
 * 发布于 15 天前
 * 131 阅读
 * 二叉树算法的设计的总路线：明确一个节点要做的事情，然后剩下的事抛给框架。
 * <p>
 * void traverse(TreeNode root) {
 * // root 需要做什么？在这做。
 * // 其他的不用 root 操心，抛给框架
 * traverse(root.left);
 * traverse(root.right);
 * }
 * 举两个简单的例子体会一下这个思路，热热身。
 * <p>
 * 1. 如何把二叉树所有的节点中的值加一？
 * <p>
 * void plusOne(TreeNode root) {
 * if (root == null) return;
 * root.val += 1;
 * <p>
 * plusOne(root.left);
 * plusOne(root.right);
 * }
 * 2. 如何判断两棵二叉树是否完全相同？
 * <p>
 * boolean isSameTree(TreeNode root1, TreeNode root2) {
 * // 都为空的话，显然相同
 * if (root1 == null && root2 == null) return true;
 * // 一个为空，一个非空，显然不同
 * if (root1 == null || root2 == null) return false;
 * // 两个都非空，但 val 不一样也不行
 * if (root1.val != root2.val) return false;
 * <p>
 * // root1 和 root2 该比的都比完了
 * return isSameTree(root1.left, root2.left)
 * && isSameTree(root1.right, root2.right);
 * }
 * 借助框架，上面这两个例子不难理解吧？如果可以理解，那么所有二叉树算法你都能解决。
 */
public class Solution100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return genList(p, null).equals(genList(q, null));
    }

    public List<Integer> genList(TreeNode treeNode, List<Integer> valueList) {
        if (null == valueList) {
            valueList = new ArrayList<>();
        }
        if (null == treeNode) {
            valueList.add(null);
            return valueList;
        }
        valueList.add(treeNode.val);
        genList(treeNode.left, valueList);
        genList(treeNode.right, valueList);
        return valueList;
    }


    public static void main(String[] args) {
        System.out.println(new Solution100().isSameTree(TreeNode.genTreeNode(1, 2, 3), TreeNode.genTreeNode(1, 2, 3)));
        System.out.println(new Solution100().isSameTree(TreeNode.genTreeNode(1, 2), TreeNode.genTreeNode(1, null, 2)));
        System.out.println(new Solution100().isSameTree(TreeNode.genTreeNode(1, 2, 1), TreeNode.genTreeNode(1, 1, 2)));

    }
}

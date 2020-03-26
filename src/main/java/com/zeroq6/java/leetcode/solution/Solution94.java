package com.zeroq6.java.leetcode.solution;

import com.zeroq6.java.leetcode.solution.help.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        process(root, result);
        return result;
    }

    /**
     * 中序即指根节点的访问在中间
     * @param treeNode
     * @param result
     */
    private void process(TreeNode treeNode, List<Integer> result){

        if(treeNode.left != null){
            process(treeNode.left, result);
        }
        result.add(treeNode.val);
        if(treeNode.right != null){
            process(treeNode.right, result);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        List<Integer> list = new Solution94().inorderTraversal(treeNode);
        System.out.println(list);
    }
}

package com.zeroq6.java.leetcode.solution.help;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer x) {
        val = x;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }


    public static TreeNode genTreeNode(Integer... arr) {
        if (null == arr || arr.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]); // 用于返回

        // 下层要在上一层上添加左右节点,所以这里记录上一层节点集合
        List<TreeNode> prevTreeNodeList = new ArrayList<>();
        prevTreeNodeList.add(root);

        Integer totalLevel = (int) Math.ceil(Math.log(arr.length + 1) / Math.log(2)); // 总共层数
        for (int i = 1; i < totalLevel; i++) { // i 从0开始, 这里第0层跳过了
            List<TreeNode> treeNodeList = new ArrayList<>();

            // 第i层(含第i层)共有2^(i + 1) - 1 个节点, 不含则有2^(i) - 1 个节点, 数组下标从0开始
            for (int j = (int) Math.pow(2, i) - 1; j < Math.min(Math.pow(2, i + 1) - 1, arr.length); j++) {
                treeNodeList.add(new TreeNode(arr[j]));
            }
            int index = 0;
            for (int k = 0; k < prevTreeNodeList.size(); k++) {
                if (index > treeNodeList.size() - 1) {
                    break;
                }
                prevTreeNodeList.get(k).left = treeNodeList.get(index++);
                if (index > treeNodeList.size() - 1) {
                    break;
                }
                prevTreeNodeList.get(k).right = treeNodeList.get(index++);
            }
            prevTreeNodeList = treeNodeList; // 下一层的上一层为当前
        }

        return root;


    }

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.PrettyFormat);
    }

}

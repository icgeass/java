package com.zeroq6.java.leetcode.solution;


import com.alibaba.fastjson.JSON;
import com.zeroq6.java.leetcode.solution.help.ArrayHelper;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * <p>
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 *
 *
 * 第一次错误
 * nums2 越界
 *
 *
 * 第二次错误
 *
 * 输入
 * [4,0,0,0,0,0]
 * 1
 * [1,2,3,5,6]
 * 5
 * 输出
 * [1,4,2,3,5,6]
 * 预期结果
 * [1,2,3,4,5,6]
 *
 */
public class Solution88 {

    /**
     * TODO
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        for (i = 0; i < m; i++) {
            if (j < n && nums1[i] > nums2[j]) {
                nums1[i] = nums1[i] + nums2[j];
                nums2[j] = nums1[i] - nums2[j];
                nums1[i] = nums1[i] - nums2[j];
                j++;
            }
        }
        for (j = 0; j < n; j++) {
            nums1[i + j] = nums2[j];
        }
    }

    public static void main(String[] args) {
        int[] num1 = ArrayHelper.genIntArray(1, 2, 3, 0, 0, 0);
        new Solution88().merge(num1, 3, ArrayHelper.genIntArray(2, 5, 6), 3);
        System.out.println(JSON.toJSONString(num1));
    }
}

package com.wellac.leetcode.tree;

/**
 * 将有序数组转换为二叉搜索树
 */
public class SortedArrayToBST_108 {

    public TreeNode sortedArrayToBST(int[] nums) {

        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);

        return root;
    }
}

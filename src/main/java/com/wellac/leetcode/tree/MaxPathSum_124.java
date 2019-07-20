package com.wellac.leetcode.tree;

/**
 * 124. 二叉树中的最大路径和
 */
public class MaxPathSum_124 {
    int sum = Integer.MAX_VALUE;

    public int maxPathSum(TreeNode root) {

        getMaxFromRoot(root);
        return sum;

    }


    private int getMaxFromRoot(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getMaxFromRoot(root.left);
        int right = getMaxFromRoot(root.right);
        sum = Math.max(Math.max(left, 0) + Math.max(right, 0) + root.val, sum);

        return Math.max(Math.max(left, right), 0) + root.val;
    }
}

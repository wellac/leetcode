package com.wellac.leetcode.tree;

/**
 * 二叉树直径
 */
public class DiameterOfBinaryTree_543 {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return max;

    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if (left + right > max) {
            max = left + right;
        }

        return left > right ? left + 1 : right + 1;
    }
}

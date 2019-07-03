package com.wellac.leetcode.tree;

/**
 * 114. 二叉树展开为链表
 */
public class Flatten_114 {
    public void flatten(TreeNode root) {
        flatten_1(root);
    }

    public TreeNode flatten_1(TreeNode root) {
        if (root == null) return root;

        TreeNode left = flatten_1(root.left);
        TreeNode right = flatten_1(root.right);

        while (left != null && left.right != null) {
            left = left.right;
        }
        if (left != null) {
            left.right = right;
            root.right = root.left;
            root.left = null;
        }

        return root;
    }
}

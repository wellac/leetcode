package com.wellac.leetcode.tree;

/**
 * 129. 求根到叶子节点数字之和
 */
public class SumNumbers_129 {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        return sum;
    }

    public void sumNumbers(TreeNode root, int num) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sum += (num * 10 + root.val);
            return;
        }
        sumNumbers(root.left, num * 10 + root.val);
        sumNumbers(root.right, num * 10 + root.val);
    }
}

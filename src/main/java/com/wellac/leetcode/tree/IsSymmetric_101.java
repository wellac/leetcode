package com.wellac.leetcode.tree;

public class IsSymmetric_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        TreeNode t1 = root.left;
        TreeNode t2 = invertTree(root.right);
        return isEqual(t1, t2);

    }

    private boolean isEqual(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        else if (t1 == null) return false;
        else if (t2 == null) return false;

        return (isEqual(t1.left, t2.left)) && (isEqual(t1.right, t2.right)) && (t1.val == t2.val);
    }

    private TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}

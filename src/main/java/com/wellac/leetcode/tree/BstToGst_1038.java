package com.wellac.leetcode.tree;

/**
 * 1038. 从二叉搜索树到更大和树
 */
public class BstToGst_1038 {
    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        setVal(root);
        return root;
    }

    //反转中序遍历法
    private void setVal(TreeNode root) {
        if (root == null) {
            return;
        }
        setVal(root.right);
        root.val += sum;
        sum = root.val;
        setVal(root.left);
    }
}

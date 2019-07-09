package com.wellac.leetcode.tree;

/**
 * 230. 二叉搜索树中第K小的元素
 */
public class KthSmallest_230 {
    int count;
    Integer res = null;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inOrder(root);
        return res;
    }

    public void inOrder(TreeNode root){
        if(root == null) return ;
        inOrder(root.left);
        if(--count == 0) {
            res = root.val;
            return;
        }
        inOrder(root.right);

    }
}

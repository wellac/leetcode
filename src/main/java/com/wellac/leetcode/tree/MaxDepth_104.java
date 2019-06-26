package com.wellac.leetcode.tree;

/**
 * 二叉树的最大深度
 */
public class MaxDepth_104 {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }

        int left_depth = maxDepth(root.left);
        int right_depth  = maxDepth(root.right);

        return left_depth>right_depth?left_depth+1:right_depth+1;
    }
}

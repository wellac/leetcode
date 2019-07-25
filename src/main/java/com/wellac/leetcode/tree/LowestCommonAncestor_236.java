package com.wellac.leetcode.tree;

/**
 * 236. 二叉树的最近公共祖先
 */
public class LowestCommonAncestor_236 {
    TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root,p,q);
        return res;
    }

    public boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return false;

        int left = helper(root.left,p,q)?1:0;
        int right = helper(root.right,p,q)?1:0;
        int curr = (root.val == p.val || root.val == q.val)?1:0;

        if(left+right+curr == 2){
            res = root;
        }
        return left+right+curr>0;
    }
}

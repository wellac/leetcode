package com.wellac.leetcode.tree;

/**
 * 235. 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }else{
            return root;
        }
    }
}

package com.wellac.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 反转二叉树
 */
public class InvertTree_226 {

    //递归遍历算法
    public TreeNode invertTree_1(TreeNode root) {
         if(root == null){
             return null;
         }
         TreeNode temp = root.left;
         root.left = invertTree_1(root.right);
         root.right = invertTree_1(temp);
         return root;
    }

    //层次遍历算法
    public TreeNode invertTree_2(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll.left!=null) queue.add(poll.left);
            if(poll.right!=null) queue.add(poll.right);
            TreeNode temp = poll.left;
            poll.left = poll.right;
            poll.right = temp;
        }
        return root;
    }
}

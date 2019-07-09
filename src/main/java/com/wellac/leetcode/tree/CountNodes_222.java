package com.wellac.leetcode.tree;

/**
 * 222. 完全二叉树的节点个数
 */
public class CountNodes_222 {

    //二分搜索法
    public int countNodes(TreeNode root) {
        int res = 0;

        TreeNode curr = root;

        while (curr != null) {
            res++;
            TreeNode left_temp = curr.left;
            TreeNode left = curr.left;
            int left_h = 0;

            TreeNode right_temp = curr.right;
            TreeNode right = curr.right;
            int right_h = 0;

            while (left != null) {
                left = left.left;
                left_h++;
            }

            while (right != null) {
                right = right.left;
                right_h++;
            }

            if (left_h == right_h) {
                res += (Math.pow(2, left_h) - 1);
                curr = right_temp;
            } else {
                res += (Math.pow(2, right_h) - 1);
                curr = left_temp;
            }
        }

        return res;
    }
}

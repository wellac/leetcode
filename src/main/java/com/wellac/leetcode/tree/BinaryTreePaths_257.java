package com.wellac.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 */
public class BinaryTreePaths_257 {
    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {

        if (root == null) return result;

        helper(root, "");

        return result;

    }

    private void helper(TreeNode root, String s) {
        if (root.left == null && root.right == null) {
            result.add(s + (s.equals("") ? root.val : ("->" + root.val)));
        }
        if (root.left != null)
            helper(root.left, s + (s.equals("") ? root.val : ("->" + root.val)));

        if (root.right != null)
            helper(root.right, s + (s.equals("") ? root.val : ("->" + root.val)));
    }
}

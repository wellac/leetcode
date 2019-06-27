package com.wellac.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 */
public class InorderTraversal_94 {
    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal_1(TreeNode root) {
        if (root == null) return result;
        inorderTraversal_1(root.left);
        result.add(root.val);
        inorderTraversal_1(root.right);
        return result;
    }

    public List<Integer> inorderTraversal_2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            TreeNode pop = s.pop();
            result.add(pop.val);
            curr = curr.right;
        }
        return result;
    }
}

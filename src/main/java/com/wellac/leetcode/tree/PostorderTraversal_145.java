package com.wellac.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 */
public class PostorderTraversal_145 {


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> s1 = new LinkedList<>();
        Deque<TreeNode> s2 = new LinkedList<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode t = s1.pop();
            s2.push(t);
            if (t.left != null) s1.push(t.left);
            if (t.right != null) s1.push(t.right);
        }

        while (!s2.isEmpty()) {
            res.add(s2.pop().val);
        }

        return res;
    }
}
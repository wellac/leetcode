package com.wellac.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 */
public class PreorderTraversal_144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> s = new Stack<>();

        s.push(root);

        while (!s.isEmpty()) {
            TreeNode t = s.pop();
            res.add(t.val);
            if (t.right != null) s.push(t.right);
            if (t.left != null) s.push(t.left);

        }

        return res;
    }


}

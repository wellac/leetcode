package com.wellac.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 */
public class RightSideView_199 {

    public List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
                if (i == size - 1) res.add(t.val);
            }
        }

        return res;
    }

    public void rightSideView(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (res.size() >= level) {
            res.set(level, root.val);
        } else {
            res.add(root.val);
        }

        rightSideView(root.left, level + 1);
        rightSideView(root.right, level + 1);
    }
}

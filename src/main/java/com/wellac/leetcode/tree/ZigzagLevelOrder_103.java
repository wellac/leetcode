package com.wellac.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigzagLevelOrder_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;

        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                if (level % 2 == 0) {
                    temp.add(t.val);
                } else {
                    temp.add(0, t.val);
                }
                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);
            }
            levels.add(temp);
            level++;
        }
        return levels;
    }
}

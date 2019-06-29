package com.wellac.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层平均值
 */
public class AverageOfLevels_637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList();

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode t = q.remove();
                sum = sum + t.val;
                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);
            }
            result.add(sum / size);
        }

        return result;
    }
}

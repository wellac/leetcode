package com.wellac.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 */
public class PathSum_113 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum, new ArrayList<>());
        return res;
    }

    private void helper(TreeNode root, int sum, List<Integer> path) {
        if (root == null) return;

        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                res.add(new ArrayList<>(path));
            }
        } else {
            helper(root.left, sum - root.val, path);
            helper(root.right, sum - root.val, path);
        }
        //回溯
        path.remove(path.size() - 1);
    }
}

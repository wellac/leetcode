package com.wellac.leetcode.dp;

import com.wellac.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 */
public class GenerateTrees_95 {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(0, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        if (start > end) {
            treeNodes.add(null);
            return treeNodes;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    treeNodes.add(root);
                }
            }
        }
        return treeNodes;
    }
}

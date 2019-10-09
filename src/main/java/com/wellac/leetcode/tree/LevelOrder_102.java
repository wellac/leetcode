package com.wellac.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 144.二叉树的层次遍历
 */
public class LevelOrder_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);//根节点入队

        while (!queue.isEmpty()) {
            int size = queue.size();//记录当前层节点数量
            ArrayList<Integer> subList = new ArrayList<>();//记录当前层节点数据
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();//出队队首元素
                subList.add(t.val);
                if (t.left != null) queue.add(t.left);//先左孩子入队
                if (t.right != null) queue.add(t.right);//再右孩子入队
            }
            result.add(subList);
        }

        return result;
    }

}

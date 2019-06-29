package com.wellac.leetcode.tree;

import java.util.*;

/**
 *  二叉树的层次遍历 II
 */
public class LevelOrderBottom_107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        int level = 1;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode t = q.remove();
                list.add(t.val);
                if(t.left!=null) q.add(t.left);
                if(t.right!=null) q.add(t.right);
            }

            result.add(list);
        }
        Collections.reverse(result);
        return result;
    }
}

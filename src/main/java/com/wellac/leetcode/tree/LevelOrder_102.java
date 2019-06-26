package com.wellac.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的层次遍历
 */
public class LevelOrder_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;

        LinkedList<TreeNode> s = new LinkedList<>();
        LinkedList<TreeNode> d = new LinkedList<>();
        s.add(root);

        while(!s.isEmpty() || !d.isEmpty()){
            List<Integer> temp = new ArrayList();
            if(!s.isEmpty()){
                while(!s.isEmpty()){
                    TreeNode t = s.poll();
                    temp.add(t.val);
                    if(t.left != null) d.add(t.left);
                    if(t.right != null) d.add(t.right);
                }
            }else{
                while(!d.isEmpty()){
                    TreeNode t = d.poll();
                    temp.add(t.val);
                    if(t.left != null) s.add(t.left);
                    if(t.right != null) s.add(t.right);
                }
            }
            result.add(temp);
        }

        return result;

    }
}

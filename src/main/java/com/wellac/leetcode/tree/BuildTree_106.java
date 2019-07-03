package com.wellac.leetcode.tree;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class BuildTree_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        root.left = buildTree(inorder, postorder, inStart, index - 1, postStart, postStart + (index - inStart - 1));
        root.right = buildTree(inorder, postorder, index + 1, inEnd, postStart + (index - inStart), postEnd - 1);
        return root;
    }
}

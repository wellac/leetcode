package com.wellac.leetcode.tree;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 */
public class Connect_117 {
    //递归解法
    public Node connect(Node root) {
        if (root == null) return null;

        Node temp = root.next;

        while (temp != null) {
            if (temp.left != null) {
                temp = temp.left;
                break;
            }
            if (temp.right != null) {
                temp = temp.right;
                break;
            }
            temp = temp.next;
        }


        if (root.right != null) {
            root.right.next = temp;
            temp = root.right;
        }

        if (root.left != null) {
            root.left.next = temp;
        }

        //注意：这个先right后left的顺序很重要
        connect(root.right);
        connect(root.left);

        return root;
    }
}

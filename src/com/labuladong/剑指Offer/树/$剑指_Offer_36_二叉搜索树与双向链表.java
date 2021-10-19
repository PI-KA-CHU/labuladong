package com.labuladong.剑指Offer.树;

import com.labuladong.分类.回溯.TreeNode;

public class $剑指_Offer_36_二叉搜索树与双向链表 {

    TreeNode preNode = null;
    TreeNode head = null;

    public TreeNode treeToDoublyList(TreeNode root) {

        if (root == null) {
            return null;
        }

        traverse(root);
        head.left = preNode;
        preNode.right = head;

        return head;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);

        if (preNode != null) {
            preNode.right = root;
            root.left = preNode;
        } else {
            head = root;
        }
        preNode = root;

        traverse(root.right);
    }
}

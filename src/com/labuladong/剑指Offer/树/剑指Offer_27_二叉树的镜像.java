package com.labuladong.剑指Offer.树;

import com.labuladong.分类.回溯.TreeNode;

public class 剑指Offer_27_二叉树的镜像 {

    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }
}

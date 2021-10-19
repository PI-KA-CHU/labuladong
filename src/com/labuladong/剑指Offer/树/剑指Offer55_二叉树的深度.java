package com.labuladong.剑指Offer.树;

import com.labuladong.分类.回溯.TreeNode;

public class 剑指Offer55_二叉树的深度 {

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return Integer.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

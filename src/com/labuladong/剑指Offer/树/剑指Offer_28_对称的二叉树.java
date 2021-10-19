package com.labuladong.剑指Offer.树;

import com.labuladong.分类.回溯.TreeNode;

public class 剑指Offer_28_对称的二叉树 {


    /**
     * 对于两个树之间的判断：
     * - 当两棵树都为null时
     * - 当其中一棵树为null时
     * - 当都不为null时
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }


    public boolean isSymmetric(TreeNode rootL, TreeNode rootR) {

        if (rootL == null && rootR == null) {
            return true;
        }

        if (rootL == null || rootR == null) {
            return false;
        }

        return rootL.val == rootR.val && isSymmetric(rootL.left, rootR.right) && isSymmetric(rootL.right, rootR.left);
    }

}

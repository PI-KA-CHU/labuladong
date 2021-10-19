package com.labuladong.剑指Offer.树;

import com.labuladong.分类.回溯.TreeNode;

public class 剑指Offer55_平衡二叉树 {

    /**
     * 后序遍历
     * 思路：后续遍历获取左右节点的深度并进行相减判断值差是否大于一，大于一则不为平衡二叉树，记录该结果。
     *
     */
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {

        treeDeep(root);
        return ans;
    }

    public int treeDeep(TreeNode root) {

        if (root == null || !ans) {
            return 0;
        }

        int leftL = treeDeep(root.left);
        int rightL = treeDeep(root.right);

        if (Math.abs(leftL - rightL) > 1) {
            ans = false;
        }

        return Integer.max(leftL, rightL) + 1;
    }
}

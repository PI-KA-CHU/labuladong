package com.labuladong.剑指Offer.树;

import com.labuladong.分类.回溯.TreeNode;

public class 剑指Offer68_二叉树的最近公共祖先 {

    /**
     * 递归（DFS - 后序遍历）
     * 思路：当q，p在root两侧时，则root为其公共祖先
     *
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        if (right == null) return left;

        return root;
    }
}

package com.labuladong.剑指Offer.树;

import com.labuladong.分类.回溯.TreeNode;

public class 剑指Offer68_二叉搜索树的最近公共祖先 {

    /**
     * 核心思路：当p，q在root两侧时该点为公共祖先
     *
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }else {
                break;
            }
        }

        return root;
    }
}

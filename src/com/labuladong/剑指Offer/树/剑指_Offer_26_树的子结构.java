package com.labuladong.剑指Offer.树;

import com.labuladong.分类.回溯.TreeNode;

public class 剑指_Offer_26_树的子结构 {

    /**
     * 思路：
     * 前序遍历二叉树，对每个节点判断B是否为子树
     *
     * 判断两个树是否为子树关系：
     * - 当B遍历到null时，return true
     * - 当A遍历到null或者A.val != B.val，return false
     *
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        // 约定空树不是任意一个树的子结构
        if (A == null || B == null) {
            return false;
        }
        return validSubStructure(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean validSubStructure(TreeNode A, TreeNode B) {

        if (B == null) {
            return true;
        }

        if (A == null || A.val != B.val) return false;

        return validSubStructure(A.left, B.left) && validSubStructure(A.right, B.right);
    }

}

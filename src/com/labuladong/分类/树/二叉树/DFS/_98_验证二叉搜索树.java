package com.labuladong.分类.树.二叉树.DFS;

import com.labuladong.分类.树.二叉树.TreeNode;

public class _98_验证二叉搜索树 {

    // 最小值最大值都用Long
    long pre = Long.MIN_VALUE;

    /**
     * 算法：中序遍历 - 当前节点值比上个节点值大即可
     * 时间：O(n)
     * 空间：O(h) h为树的高度
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean validL = isValidBST(root.left);

        if (root.val <= pre) {
            return false;
        }
        pre = root.val;

        boolean validR = isValidBST(root.right);

        return validR && validL;
    }
}

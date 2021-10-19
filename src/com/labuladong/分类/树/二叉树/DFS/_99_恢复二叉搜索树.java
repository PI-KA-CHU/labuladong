package com.labuladong.分类.树.二叉树.DFS;

import com.labuladong.分类.树.二叉树.TreeNode;

public class _99_恢复二叉搜索树 {

    TreeNode preNode = null;

    TreeNode x = null;
    TreeNode y = null;


    /**
     * *推荐
     * - 二叉搜索树的中序遍历是有序的
     *
     * 方法一：dfs中序遍历将节点遍历存储到数组中，通过对比数组中顺序找出问题节点
     * - 时间：O(n)
     * - 空间：O(n)
     *
     * 方法二：dfs中序遍历到同时，通过pre指针记录pre节点，比较当前节点和上个节点到关系，边递归边寻找问题节点
     * - 时间：O(n)
     * - 空间：O(height)
     */
    public void recoverTree(TreeNode root) {

        traverse(root);

        if (x != null && y != null) {
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);

        if (preNode != null && root.val < preNode.val) {
            if (x == null) {
                x = preNode;
            }
            y = root;
        }
        preNode = root;

        traverse(root.right);
    }
}

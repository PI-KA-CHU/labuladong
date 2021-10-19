package com.labuladong.分类.树.二叉树.DFS;

import com.labuladong.分类.树.二叉树.TreeNode;

public class _538_把二叉搜索树转换为累加树 {


    /**
     * *推荐
     *
     * 思路：
     *  累加的定义是累加>=当前值的值，采用反序中序遍历获得的值是递减的，所以累加当前节点的值并替换当前节点的值
     *
     * 时间：O(n)
     * 空间：O(n)
     */
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {

        if (root == null) {
            return null;
        }

        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);

        return root;
    }


    /**
     * 思路：先求出所有节点的值的和，再中序遍历逐步减去上一个值并替换为当前节点的值（中序遍历是递增）
     * 时间：O(n)
     * 空间：O(n) ：二叉搜索树的高度最坏情况为n
     */
    int treeSum = 0;
    public TreeNode convertBST2(TreeNode root) {
        treeSum = calculate(root);
        traverse(root);

        return root;
    }

    public int calculate(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = calculate(root.left);
        int right = calculate(root.right);

        return root.val + left + right;
    }

    public void traverse(TreeNode root) {

        if (root == null) {
            return;
        }

        traverse(root.left);

        int rootVal = root.val;
        root.val = treeSum;
        treeSum = treeSum - rootVal;

        traverse(root.right);
    }
}

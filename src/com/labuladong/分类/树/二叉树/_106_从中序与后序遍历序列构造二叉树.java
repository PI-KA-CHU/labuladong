package com.labuladong.分类.树.二叉树;

import java.util.HashMap;
import java.util.Map;

public class _106_从中序与后序遍历序列构造二叉树 {

    /**
     * 递归构建子树根节点
     * - 该题的重点是找出根结点和控制指针
     *
     * 时间：O(n)
     * 空间：O(n) ：需要哈希表存储中序遍历以确定跟节点下标
     * 中序遍历确定左右子树的长度（以此控制指针）
     * 后序遍历确定root节点
     */
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int i1, int i2, int p1, int p2) {

        if (i1 > i2 || p1 > p2) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[p2]);
        int rootIndex = map.get(root.val);

        int leftL = rootIndex - i1;
        root.left = buildTree(inorder, postorder, i1, i1 + leftL - 1, p1, p1 + leftL - 1);
        root.right = buildTree(inorder, postorder, rootIndex + 1, i2, p1 + leftL, p2 - 1);

        return root;
    }

}

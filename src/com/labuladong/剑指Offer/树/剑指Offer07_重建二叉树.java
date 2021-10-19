package com.labuladong.剑指Offer.树;

import com.labuladong.分类.回溯.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class 剑指Offer07_重建二叉树 {

    /**
     * 思路：中序突破，递归构建根节点
     * 难点：边界取值
     *  总结：index + len为闭区间（正常取得所有值），rightIndex - leftIndex得出的长度少了一个（半开）
     */
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

       return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }

    public TreeNode build(int[] preorder, int p1, int p2, int[] inorder, int i1, int i2) {

        if (p1 > p2 || i1 > i2) {
            return null;
        }

        int rootV = preorder[p1];
        TreeNode root = new TreeNode(rootV);
        int rootIndex = map.get(rootV);

        int leftL = rootIndex - i1;

        root.left = build(preorder, p1 + 1, p1 + leftL, inorder, i1, rootIndex - 1);
        root.right = build(preorder, p1 + leftL + 1, p2, inorder, rootIndex + 1, i2);

        return root;
    }

}

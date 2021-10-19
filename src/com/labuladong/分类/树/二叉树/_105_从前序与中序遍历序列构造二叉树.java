package com.labuladong.分类.树.二叉树;

import java.util.HashMap;
import java.util.Map;

public class _105_从前序与中序遍历序列构造二叉树 {

    /**
     * 通过递归构建树的根节点及左右子树
     * 递归核心：根节点构建 + 递归构建左右子树
     * 思路：
     *  前序：首节点即为根节点
     *  中序：知道首节点就可以知道左右子树长度
     *  通过上面两个数据即可以确定并构建根节点，并通过左右子树长度控制子树的前序、中序遍历，递归构建树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildMyTree(preorder, inorder, map, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildMyTree(int[] preorder, int[] inorder, Map<Integer, Integer> inMap, int p1, int p2, int i1, int i2) {

        if (p1 < 0 || p2 >= preorder.length || p1 > p2) {
            return null;
        }

        if (i1 < 0 || i2 >= inorder.length || i1 > i2) {
            return null;
        }

        int rootIndex = inMap.get(preorder[p1]);
        int leftL = rootIndex - i1;
        int rightL = i2 - rootIndex;

        TreeNode root = new TreeNode(preorder[p1]);
        root.left = buildMyTree(preorder, inorder, inMap, p1 + 1, p1 + leftL, i1, rootIndex - 1);
        root.right = buildMyTree(preorder, inorder, inMap, p1 + leftL + 1, p1 + leftL + rightL, rootIndex + 1, i2);

        return root;
    }

}

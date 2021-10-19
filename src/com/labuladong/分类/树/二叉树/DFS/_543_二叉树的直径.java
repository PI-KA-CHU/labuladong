package com.labuladong.分类.树.二叉树.DFS;


import com.labuladong.分类.树.二叉树.TreeNode;

import static java.lang.Math.max;

public class _543_二叉树的直径 {

    /**
     * *推荐
     * 利用深度优先搜索
     * - 记住计算最大深度的递归方法
     *
     * 时间：O(n)
     * 空间：O(height)，height为树的高度
     */
    int maxd = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxd;
    }

    public int depth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int maxLeft = depth(root.left);
        int maxRight = depth(root.right);

        maxd = max(maxLeft + maxRight, maxd);
        return max(maxLeft, maxRight) + 1;
    }
}

package com.labuladong.分类.树.二叉树.DFS;


import com.labuladong.分类.树.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.max;

public class _104_二叉树的最大深度 {

    /**
     * 方法一：深度遍历
     * 当前节点的最大深度为max(leftH, rightH) + 1
     *
     * 方法二：广度遍历，记录层数
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftH = maxDepth(root.left);
        int rightH = maxDepth(root.right);

        return max(leftH, rightH) + 1;
    }

    public int maxDepth2(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            depth ++;
        }

        return depth;
    }

}

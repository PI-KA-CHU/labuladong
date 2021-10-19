package com.labuladong.分类.树.二叉树.BFS;

import com.labuladong.分类.树.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _111_二叉树的最小深度 {


    /**
     * *推荐
     * 广度优先遍历好理解
     *
     * 时间：O(n)
     * 空间：O(n)
     */
    public int minDepth2(TreeNode root) {
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

                //访问到到的第一个叶子节点时的深度就是最小深度
                if (node.left == null && node.right == null) {
                    return depth + 1;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth ++;
        }
        return 0;
    }


    /**
     * 递归需要考虑结束条件：
     * - 1. 左右子树为null时返回1
     * - 2. 左右子树其中一个为null时范围 max(depthL, depthR) + 1 或者 depthL + depthR + 1
     * - 3. 左右子树都不为null，返回 min(depthL, depthR) + 1
     *
     * 时间：O(n)
     * 空间：O(n)
     */
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        //1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if (root.left == null && root.right == null) {
            return 1;
        }

        //2.如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度
        int leftL = minDepth(root.left);
        int rightL = minDepth(root.right);

        if (root.left == null || root.right == null) {
            return leftL + rightL + 1;
        }

        //3.最后一种情况，也就是左右孩子都不为空，返回最小深度+1即可
        return Integer.min(leftL, rightL) + 1;
    }


}

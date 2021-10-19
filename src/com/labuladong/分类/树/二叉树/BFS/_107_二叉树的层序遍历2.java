package com.labuladong.分类.树.二叉树.BFS;

import com.labuladong.分类.树.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _107_二叉树的层序遍历2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if (root == null) {
            return new LinkedList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<List<Integer>> ans = new LinkedList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> ansS = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                ansS.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            ans.add(0, ansS);
        }

        return ans;
    }
}

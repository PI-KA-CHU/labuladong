package com.labuladong.分类.树.二叉树.BFS;

import com.labuladong.分类.树.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102_二叉树的层序遍历 {


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();

            List<Integer> levelAns = new ArrayList<>();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode treeNode = queue.poll();
                levelAns.add(treeNode.val);

                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }

                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            ans.add(levelAns);
        }

        return ans;
    }
}

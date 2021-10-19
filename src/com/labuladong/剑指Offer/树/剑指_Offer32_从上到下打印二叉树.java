package com.labuladong.剑指Offer.树;

import com.labuladong.分类.回溯.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 剑指_Offer32_从上到下打印二叉树 {

    public int[] levelOrder(TreeNode root) {

        if (root == null) {
            return new int[0];
        }

        List<Integer> ansL = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();

        queue.offer(root);
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            ansL.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        int[] ans = new int[ansL.size()];
        for (int i = 0; i < ansL.size(); i++) {
            ans[i] = ansL.get(i);
        }

        return ans;
    }
}

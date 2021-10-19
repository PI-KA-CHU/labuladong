package com.labuladong.剑指Offer.树;

import com.labuladong.分类.回溯.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 剑指Offer32_从上到下打印二叉树3 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new LinkedList<>();
        }

        int flag = 0;

        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            List<Integer> subAns = new LinkedList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (flag % 2 == 0) {
                    subAns.add(node.val);
                } else {
                    subAns.add(0, node.val);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            flag ++;
            ans.add(subAns);

        }

        return ans;
    }

}

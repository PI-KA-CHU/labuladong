package com.labuladong.剑指Offer.树;

import com.labuladong.分类.回溯.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 剑指_Offer34_二叉树中和为某一值的路径 {

    List<Integer> subAns = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {

        int sum = 0;
        traverse(root, target);

        return ans;
    }

    public void traverse(TreeNode root, int target) {

        // 叶子节点的
        if (root == null) {
            return;
        }

        target -= root.val;
        subAns.add(root.val);

        if (root.left == null && root.right == null) {
            if (target == 0) {
                ans.add(new ArrayList<>(subAns));
            }
        }

        traverse(root.left, target);
        traverse(root.right, target);
        subAns.remove(subAns.size() - 1);
    }

}

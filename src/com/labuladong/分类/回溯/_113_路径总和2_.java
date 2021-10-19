package com.labuladong.分类.回溯;

import java.util.LinkedList;
import java.util.List;

public class _113_路径总和2_ {

    LinkedList<Integer> ansP = new LinkedList<>();
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        traverse2(root, targetSum);
        return ans;
    }


    public void traverse1(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        //targetSum为形参，不需要回溯
        targetSum -= root.val;
        ansP.addLast(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                //需要new新的，否则指向的是指针，值都为空
                ans.add(new LinkedList<>(ansP));
            }
        }

        traverse1(root.left, targetSum);
        traverse1(root.right, targetSum);

        //回溯
        ansP.removeLast();
    }

    int ansSum = 0;
    public void traverse2(TreeNode root, int targetSum) {

        if (root == null) {
            return;
        }

        ansSum += root.val;
        ansP.addLast(root.val);
        if (root.left == null && root.right == null) {
            if (ansSum == targetSum) {
                //需要new新的，否则指向的是指针，值都为空
                ans.add(new LinkedList<>(ansP));
            }
        }

        traverse2(root.left, targetSum);
        traverse2(root.right, targetSum);

        ansSum -= root.val;
        ansP.removeLast();
    }


}

package com.labuladong.分类.树.二叉树.DFS;

import com.labuladong.分类.树.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _94_二叉树的中序遍历 {


    /**
     * 递归实现
     * 时间复杂度：O(n) ，n为二叉树的节点数
     * 空间复杂度：O(n)，取决于栈的深度
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }


    public List<Integer> inorder2(TreeNode root) {

        Deque<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        while (root != null || !q.isEmpty()) {
            //走完最左边
            while (root != null) {
                q.push(root);
                root = root.left;
            }
            //拿出栈节点保存值
            root = q.pop();
            res.add(root.val);
            //走右边节点
            root = root.right;
        }

        return res;
    }


}

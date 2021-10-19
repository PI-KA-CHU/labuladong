package com.labuladong.分类.树.二叉树;

import java.util.LinkedList;
import java.util.List;

public class _95_不同的二叉搜索树2 {

    /**
     * 回溯法
     *
     * 思路：for循环以逐个点为根节点，获取左右子树集，两个for嵌套左右子树集合，构建二叉树
     * - 传参：start, end （以i为根节点，则左树为 [start, i-1] , 右树为[i+1, end]）
     */
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    public List<TreeNode> generate(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();

        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generate(start, i - 1);
            List<TreeNode> rightTrees = generate(i + 1, end);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
    }

}

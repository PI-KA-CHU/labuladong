package com.labuladong.分类.树.二叉树.DFS;

import com.labuladong.分类.回溯.TreeNode;

public class _230_二叉搜索树中第K小的元素 {

    /**
     * 中序遍历
     * 思路：二叉搜索树的中序遍历是递增的，记录当前在第几个节点，当为k时即为所求
     *
     * 时间：O(n)
     * 空间：O(1)
     */
    int ans = -1;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {

        dfs(root, k);

        return ans;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        dfs(root.left, k);
        ++count;
        if (count == k) {
            ans = root.val;
            return;
        }
        dfs(root.right, k);
    }

}

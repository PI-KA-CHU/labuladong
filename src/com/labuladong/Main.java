package com.labuladong;

import static java.lang.Integer.max;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * 模版：后序遍历
 *
 * 以最简单的三个节点的二叉树为例子
 * 注意：
 * 1. 节点都为负数（ans = MIN_VALUE）
 * 2. 左右子树抛弃负数（max(0,*)）
 */
public class Main {

    // 当整棵树都为负数的情况
    int ans = Integer.MIN_VALUE;

    public static void main(String[] args) {
        // write your code here
    }

    public int maxPathSum(TreeNode root) {
        oneSideMax(root);
        return ans;
    }

    public int oneSideMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // max(0,*) 抛弃负数值
        int left = max(0, oneSideMax(root.left));
        int right = max(0, oneSideMax(root.right));

        //root.val为必经的节点，不可以舍弃，而left、right为负数都被舍弃了，加起来就是最大路径和
        ans = max(ans, left + right + root.val);

        return max(left, right) + root.val;
    }

}

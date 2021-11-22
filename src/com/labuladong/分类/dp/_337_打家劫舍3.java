package com.labuladong.分类.dp;

import com.labuladong.分类.回溯.TreeNode;

public class _337_打家劫舍3 {

    public int rob(TreeNode root) {
        int[] res = robInternal(root);
        return Integer.max(res[0], res[1]);
    }

    public int[] robInternal(TreeNode root) {
        if (root == null) return new int[2];
        int[] res = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        res[0] = left[1] + right[1] + root.val;
        res[1] = Integer.max(left[0], left[1]) + Integer.max(right[0], right[1]);

        return res;
    }
}

package com.labuladong.分类.树.二叉树;

public class _96_不同的二叉搜索树 {

    /**
     * 动态规划
     *
     * 设当n个节点时，不同的二叉树数目为G(n)，f(i)表示以i为根节点，存在的不同的二叉树数目
     * 则：
     *  G(n) = f(1) + f(2) + ... + f(n)
     *  f(i) = G(i-1) * G(n - i) 【即左子树不同数 * 右子树不同数】
     *
     * 得：
     *  G(n) = G(1) * G(0) + ... G(n) * G(n-1)
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        // i代表有几个数
        for (int i = 2; i <= n; i++) {
            // j代表以哪个为根节点
            for (int j = 1; j <= i; j++) {
                // 各个案例的左右子树相乘
                dp[i] += dp[j-1] * dp[i-j];
            }
        }

        return dp[n];
    }
}

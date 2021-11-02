package com.labuladong.分类.dp;

public class $_221_最大正方形 {

    /**
     * 动态规划
     * 思路：dp[i][j]表示该位置的最大正方形边长
     * - matrix[]i[j] == '1'：dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]) + 1
     * - 表示该位置为'1'，则其最大正方形由其其他三个角的最小值+当前边长1确定
     *
     * 时间：O(m*n)
     * 空间：O(m*n)
     *
     */
    public int maximalSquare(char[][] matrix) {

        int[][] dp = new int[matrix.length][matrix[0].length];

        int maxSide = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Integer.min(dp[i - 1][j], Integer.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }

                    maxSide = Integer.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }
}

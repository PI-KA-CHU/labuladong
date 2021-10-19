package com.labuladong.分类.dp.股票;

public class _714_买卖股票的最佳时机含手续费 {

    /**
     * 动态规划
     *
     * 思路：dp[状态1：天数][状态2：是否持有]
     * 1. dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i] - prices[i-1] - fee)
     *  今天不持有股票的最大利润为：max(昨天也不持有股票的利 ｜ 昨天持有股票，今天才卖出，需要减去手续费)
     * 2. dp[i][1] = max(dp[i-1][0], dp[i-1][1] + prices[i] - prices[i-1])
     *  今天持有股票的最大利润：max(昨天不持有股票的利润，今天买入 ｜ 昨天持有，今天依然持有)
     *
     *  时间：O(n)
     *  空间：O(n)
     */
    public int maxProfit(int[] prices, int fee) {

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Integer.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - prices[i-1] - fee);
            dp[i][1] = Integer.max(dp[i - 1][0], dp[i - 1][1] + (prices[i] - prices[i - 1]));
        }

        return dp[prices.length - 1][0];
    }

    /**
     * 状态只由前面两个状态转移来，可以进行优化
     *
     * 时间：O(n)
     * 空间：O(1)
     */
    public int maxProfit2(int[] prices, int fee) {

        int sell = 0; //今天行为为卖出
        int bug = 0; //今天行为为买入

        for (int i = 1; i < prices.length; i++) {
            sell = Integer.max(sell, bug + prices[i] - prices[i - 1] - fee);
            bug = Integer.max(sell, bug + prices[i] - prices[i - 1]);
        }

        return sell;
    }
}

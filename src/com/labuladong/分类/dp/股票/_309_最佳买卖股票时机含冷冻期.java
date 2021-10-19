package com.labuladong.分类.dp.股票;

public class _309_最佳买卖股票时机含冷冻期 {

    public static int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length][3];

        dp[0][0] = -prices[0];  //第i天后，股票处于买入状态
        dp[0][1] = 0;   //第i天后，股票处于卖出且非冷冻期状态
        dp[0][2] = 0;   //第i天后，股票处于卖出且冷冻期状态

        // 由当天结束后的状态推断当天的动作
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Integer.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Integer.max(dp[i - 1][1], dp[i - 1][2]); //今天无操作
            dp[i][2] = dp[i][0] + prices[i];
        }

        return Integer.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }

    public static void main(String[] args) {
        int[] prices = {1, 2};
        maxProfit(prices);
    }
}

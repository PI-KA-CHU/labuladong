package com.labuladong.分类.贪心;

public class _122_买卖股票的最佳时机2 {


    /**
     * 推荐
     * - 题解有优秀参考
     *
     * 贪心算法
     * 思路：把所有上坡的钱都收集起来即为最大利润
     *
     * 时间：O(n)
     * 空间：O(1)
     */
    public int maxProfit2(int[] prices) {
        if (prices == null) {
            return 0;
        }

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            //只有赚钱了才卖出
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }


    /**
     * 动态规划
     *
     * 时间：O(n)
     * 空间：O(n)
     */
    public int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Integer.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - prices[i - 1]);
            dp[i][1] = Integer.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - prices[i - 1]);
        }

        return dp[prices.length - 1][0];
    }

}

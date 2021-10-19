package com.labuladong.分类.dp.股票;

public class _121_买卖股票的最佳时机 {

    /**
     * 推荐
     * 思路：假如在第i天卖出股票，那么就在[0,i-1]天的最低点买入，遍历数组求各个天数卖出时的最大收益即可
     *
     * 时间：O(n)
     * 空间：O(1)
     */
    public int maxProfit(int[] prices) {

        int minPrices = Integer.MAX_VALUE;
        int ans = 0;
        for (int price : prices) {
            if (price < minPrices) {
                minPrices = price;
            } else if (price > minPrices) {
                ans = Integer.max(ans, price - minPrices);
            }
        }

        return ans;
    }

}

package com.labuladong.分类.dp.股票;

public class _123_买卖股票的最佳时机3 {

    /**
     * 在任意一天结束后，股票会处于以下五种状态中的一种
     * - 未进行过任何操作
     * - 只进行过一次买操作
     * - 进行了一次完整交易（一次买一次卖）
     * - 进行了一次完整交易和第二次买入
     * - 进行了两次完整交易
     */

    public int maxProfit(int[] prices) {

        //base case
        //当天买入
        int buy1 = -prices[0];
        //当天一次买卖
        int sell1 = 0;
        //当天一次买卖后再买入
        int buy2 = -prices[0];
        //当天两次买卖
        int sell2 = 0;

        for (int i = 1; i < prices.length; i++) {
            buy1 = Integer.max(buy1, -prices[i]);
            sell1 = Integer.max(sell1, buy1 + prices[i]);
            buy2 = Integer.max(buy2, sell1 - prices[i]);
            sell2 = Integer.max(sell2, buy2 + prices[i]);
        }

        return sell2;
    }
}

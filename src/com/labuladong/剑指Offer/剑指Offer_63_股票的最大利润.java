package com.labuladong.剑指Offer;

public class 剑指Offer_63_股票的最大利润 {

    public int maxProfit(int[] prices) {

        int minPrice = 0;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }

                if (minPrice > prices[i]) {
                    minPrice = prices[i];
                }
            }
        }

        return maxProfit;
    }
}

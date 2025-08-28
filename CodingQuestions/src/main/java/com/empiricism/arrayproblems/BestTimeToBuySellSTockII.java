package com.empiricism.arrayproblems;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

public class BestTimeToBuySellSTockII {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            // Greedy: if today's price > yesterday's, we profit
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;

    }
}

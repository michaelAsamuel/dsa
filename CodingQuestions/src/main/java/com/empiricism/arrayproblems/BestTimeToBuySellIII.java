package com.empiricism.arrayproblems;

public class BestTimeToBuySellIII {
    static int maxProfitDP(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int[] left = new int[n];
        int[] right = new int[n];

        // Forward pass
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - minPrice);
        }

        // Backward pass
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            right[i] = Math.max(right[i + 1], maxPrice - prices[i]);
        }

        // Combine profits
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }

        return maxProfit;

    }

    public static void main(String[] args) {
//        System.out.println(maxProfitDP(new int[]{3,3,5,0,0,3,1,4})); //Exp: 6
//        System.out.println(maxProfitDP(new int[]{1,2,3,4,5})); //Exp: 4
//        System.out.println(maxProfitDP(new int[]{7,6,4,3,1})); //Exp: 0

        System.out.println(maxProfit(new int[]{3,3,5,0,0,3,1,4})); //Exp: 6
//        System.out.println(maxProfit(new int[]{1,2,3,4,5})); //Exp: 4
//        System.out.println(maxProfit(new int[]{7,6,4,3,1})); //Exp: 0
    }

    static int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;

        for (int price : prices) {
            firstBuy = Math.max(firstBuy, -price);
            firstSell = Math.max(firstSell, firstBuy + price);
            secondBuy = Math.max(secondBuy, firstSell - price);
            secondSell = Math.max(secondSell, secondBuy + price);
            System.out.println(firstBuy);
            System.out.println(firstSell);
            System.out.println(secondBuy);
            System.out.println(secondSell);
            System.out.println("---------");
        }

        return secondSell;
    }


}

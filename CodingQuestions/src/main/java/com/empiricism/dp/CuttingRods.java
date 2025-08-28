package com.empiricism.dp;

import java.util.Arrays;

public class CuttingRods {
    public static int cutRod(int[] lengths, int[] prices, int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < lengths.length; j++) {
                if (lengths[j] <= i) {
                    dp[i] = Math.max(dp[i], prices[j] + dp[i - lengths[j]]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        // Rod length
        int n = 8;

        // Marketable lengths and corresponding prices
        int[] lengths = {1, 2, 3, 4};
        int[] prices = {1, 5, 8, 9};

//        int maxProfit = cutRod(lengths, prices, n);
        int maxProfit = cutRodSize(lengths, prices,n);
        System.out.println("Maximum Profit: " + maxProfit);
    }


    public static int cutRodSize(int[] lengths, int[] prices, int n) {
        int[] dp = new int[n + 1];
        int[] cuts = new int[n + 1]; // To track the cuts

        // We loop through each unit of the log length 9n0
        for (int i = 1; i <= n; i++) {
            // for each possible cut we get the price - notice we are reusing previous value
            for (int j = 0; j < lengths.length; j++) {
                if (lengths[j] <= i) {

                    int profit = prices[j] + dp[i - lengths[j]];
                    if (profit > dp[i]) {
                        dp[i] = profit;
                        cuts[i] = lengths[j];
                    }
                }
            }
        }

        // Print the cut sizes
        System.out.print("Cuts used for maximum profit: ");
        int remaining = n;
        while (remaining > 0) {
            System.out.print(cuts[remaining] + " ");
            remaining -= cuts[remaining];
        }

        System.out.println(); // newline
        return dp[n];
    }

}

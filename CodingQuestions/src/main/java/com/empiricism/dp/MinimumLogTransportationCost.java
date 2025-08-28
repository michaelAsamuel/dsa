package com.empiricism.dp;

import java.util.Arrays;

public class MinimumLogTransportationCost {

    public static long minCost(int[] logs, int k) {
        int n = logs.length;

        // Prefix sum computation
        long[] prefix = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + logs[i - 1];
        }

        // DP array
        long[][] dp = new long[n + 1][k + 1];
        for (long[] row : dp) Arrays.fill(row, Long.MAX_VALUE);
        dp[0][0] = 0;  // Base case: 0 logs into 0 groups costs 0

        for (int g = 1; g <= k; g++) {
            for (int i = g; i <= n; i++) {
                for (int j = g - 1; j < i; j++) {
                    long groupSum = prefix[i] - prefix[j];
                    int groupLen = i - j;
                    long cost = groupSum * groupLen;
                    if (dp[j][g - 1] != Long.MAX_VALUE) {
                        dp[i][g] = Math.min(dp[i][g], dp[j][g - 1] + cost);
                    }
                }
            }
        }

        return dp[n][k];
    }


    public static void main(String[] args) {
        int[] logs1 = {1, 2, 3, 4, 5};
        int k1 = 2;
        System.out.println("Minimum cost: " + minCost(logs1, k1));
        // Expected output: 36

        int[] logs2 = {10, 20, 30};
        int k2 = 1;
        System.out.println("Minimum cost: " + minCost(logs2, k2));
        // Expected output: (10+20+30)*3 = 60 * 3 = 180

        int[] logs3 = {5, 1, 2, 1, 5};
        int k3 = 3;
        System.out.println("Minimum cost: " + minCost(logs3, k3));
    }

//    public static long minCost(int n, int m, int k) {
//
//
//        // Prefix sum computation
////        long[] prefix = new long[n + 1];
////        for (int i = 1; i <= n; i++) {
////            prefix[i] = prefix[i - 1] + logs[i - 1];
////        }
//
//        // DP array
//        long[][] dp = new long[n + 1][k + 1];
//        for (long[] row : dp) Arrays.fill(row, Long.MAX_VALUE);
//        dp[0][0] = 0;  // Base case: 0 logs into 0 groups costs 0
//
//        for (int g = 1; g <= k; g++) {
//            for (int i = g; i <= n; i++) {
//                for (int j = g - 1; j < i; j++) {
//                    long groupSum = pref - prefix[j];
//                    int groupLen = i - j;
//                    long cost = groupSum * groupLen;
//                    if (dp[j][g - 1] != Long.MAX_VALUE) {
//                        dp[i][g] = Math.min(dp[i][g], dp[j][g - 1] + cost);
//                    }
//                }
//            }
//        }
//
//        return dp[n][k];
//    }
}


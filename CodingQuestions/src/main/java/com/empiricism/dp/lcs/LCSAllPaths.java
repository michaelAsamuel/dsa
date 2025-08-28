package com.empiricism.dp.lcs;

import java.sql.SQLOutput;
import java.util.*;

public class LCSAllPaths {
    public static void main(String[] args) {
        String text1 = "CADENCE";
        String text2 = "CASCADE";

        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Step 1: Fill the DP Matrix
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Step 2: Visualize the DP Matrix with LCS path arrows
        System.out.println("DP Matrix with arrows (↖ for match):");
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i > 0 && j > 0 && text1.charAt(i - 1) == text2.charAt(j - 1)) {
//                    System.out.println("\u2196 This is the match path");
                    System.out.print("↖" + dp[i][j] + " ");
                } else {
                    System.out.print(" " + dp[i][j] + " ");
                }
            }
            System.out.println();
        }

        // Step 3: Get All LCS Strings

        Set<String> allLCS = getAllLCS(dp, text1, text2, m, n, new HashMap<>());
        System.out.println("\nAll LCS strings:");
        for (String s : allLCS) {
            System.out.println(s);
        }
        System.out.println("----------------");
        System.out.println( getOneLCS(dp, text1, text2));
    }

    // Step 3: Recursive Backtracking with Memoization
    private static Set<String> getAllLCS(int[][] dp, String text1, String text2, int i, int j, Map<String, Set<String>> memo) {
        Set<String> result = new HashSet<>();

        if (i == 0 || j == 0) {
            result.add("");
            return result;
        }

        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
            Set<String> temp = getAllLCS(dp, text1, text2, i - 1, j - 1, memo);
            for (String s : temp) {
                result.add(s + text1.charAt(i - 1));
            }
        } else {
            if (dp[i - 1][j] >= dp[i][j - 1]) {
                result.addAll(getAllLCS(dp, text1, text2, i - 1, j, memo));
            }
            if (dp[i][j - 1] >= dp[i - 1][j]) {
                result.addAll(getAllLCS(dp, text1, text2, i, j - 1, memo));
            }
        }

        memo.put(key, result);
        return result;
    }

    public static String getOneLCS(int[][] dp, String text1, String text2) {
        StringBuilder lcs = new StringBuilder();
        int i = text1.length(), j = text2.length();

        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                lcs.append(text1.charAt(i - 1));  // matching char
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;  // move up
            } else {
                j--;  // move left
            }
        }

        return lcs.reverse().toString();
    }

}


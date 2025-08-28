package com.empiricism.dp.paths;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        return countPathsRecur(0, 0, m, n);
    }

    private int countPathsRecur(int row, int col, int m, int n) {
        // If we reach the bottom-right cell, we found one path
        if (row == m - 1 && col == n - 1) {
            return 1;
        }


        // If we go out of bounds
        if (row >= m || col >= n) {
            return 0;
        }

        // Move right and move down
        int rightPaths = countPathsRecur(row, col + 1, m, n);
        int downPaths = countPathsRecur(row + 1, col, m, n);

        return rightPaths + downPaths;
    }

    public static void main(String[] args) {
        UniquePaths obj = new UniquePaths();
        System.out.println(obj.uniquePaths(4, 4)); // Output: 28
        System.out.println(obj.uniquePaths(3, 7)); // Output: 28
        System.out.println(obj.uniquePathsBotUp(3, 7)); // Output: 28
        System.out.println(obj.uniquePaths(23, 12)); // Output: 2193536720
        System.out.println(obj.uniquePathsBotUp(23, 12)); // Output: 193536720
//        System.out.println(obj.countPathsMemo(0,0,23, 12)); // Output: 193536720
    }

    int uniquePathsBotUp(int m, int n) {
        int[][] dp = new int[m][n];

        // Fill bottom-right with 1 (base case)
        for (int i = 0; i < m; i++) dp[i][n - 1] = 1;
        for (int j = 0; j < n; j++) dp[m - 1][j] = 1;

        // Fill from bottom-right to top-left
        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                dp[row][col] = dp[row + 1][col] + dp[row][col + 1];
            }
        }

        return dp[0][0];
    }

    int countPathsMemo(int row, int col, int m, int n) {
        int[][] dp = new int[m][n];
        if (row == m - 1 && col == n - 1) return 1;
        if (row >= m || col >= n) return 0;
        return countPathsMemo(row + 1, col, m, n) + countPathsMemo(row, col + 1, m, n);
    }



    int countPathsMemo(int row, int col, int m, int n, int[][] dp) {
        if (row == m - 1 && col == n - 1) return 1;
        if (row >= m || col >= n) return 0;

        if (dp[row][col] != 0) return dp[row][col]; // Memoization step

        dp[row][col] = countPathsMemo(row + 1, col, m, n, dp) + countPathsMemo(row, col + 1, m, n, dp);
        return dp[row][col];
    }



}


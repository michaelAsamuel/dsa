package com.empiricism.dp.paths;

//https://leetcode.com/problems/minimum-path-sum/

import static com.empiricism.dp.paths.GridDrawer.printGrid;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        // Initialize the starting point
        dp[0][0] = grid[0][0];

        // Fill first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Fill first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // Fill the rest
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        printGrid(dp);
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        MinimumPathSum obj = new MinimumPathSum();
        System.out.println(obj.minPathSum(grid)); // expected 7
        int[][] grid1 ={{1,2,3},{4,5,6}};
        System.out.println(obj.minPathSum(grid1)); // expected 12
    }
}

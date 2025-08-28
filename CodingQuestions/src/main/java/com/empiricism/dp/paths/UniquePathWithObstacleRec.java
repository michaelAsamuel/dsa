package com.empiricism.dp.paths;

public class UniquePathWithObstacleRec {


        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            return countPaths(obstacleGrid, 0, 0);
        }

        private int countPaths(int[][] grid, int row, int col) {
            int m = grid.length;
            int n = grid[0].length;

            // If out of bounds or obstacle, return 0
            if (row >= m || col >= n || grid[row][col] == 1) {
                return 0;
            }

            // If reached destination
            if (row == m - 1 && col == n - 1) {
                return 1;
            }

            // Recursive calls: right and down
            int rightPaths = countPaths(grid, row, col + 1);
            int downPaths = countPaths(grid, row + 1, col);

            return rightPaths + downPaths;
        }

    int uniquePathsBotUp(int[][] obstacleGrid) {
            int m= obstacleGrid.length;
            int n= obstacleGrid[0].length;

            if(obstacleGrid[m-1][n-1]==1) return 0;

            int[][] dp = new int[m][n];

            // Fill bottom-right with 1 (base case)
            for (int i = m - 1; i >= 0; i--) {
                if (obstacleGrid[i][n - 1] == 1) {
                    dp[i][n - 1] = 0;
                } else {
                    // If it's the last cell (bottom-right), start with 1
                    if (i == m - 1)
                        dp[i][n - 1] = 1;
                    else
                        dp[i][n - 1] = dp[i + 1][n - 1];
                }
            }
            // Initialize last row (bottom-most row)
            for (int j = n - 1; j >= 0; j--) {
                if (obstacleGrid[m - 1][j] == 1) {
                    dp[m - 1][j] = 0;
                } else {
                    if (j == n - 1)
                        dp[m - 1][j] = 1; // bottom-right cell
                    else
                        dp[m - 1][j] = dp[m - 1][j + 1];
                }
            }

            // Fill from bottom-right to top-left
            for (int row = m - 2; row >= 0; row--) {
                for (int col = n - 2; col >= 0; col--) {
                    if(obstacleGrid[row][col]==1){
                        dp[row][col]=0 ;
                    }else{
                        dp[row][col] = dp[row + 1][col] + dp[row][col + 1];
                    }

                }
            }

            return dp[0][0];

    }


}

package com.empiricism.dp.paths;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        // Start from the second row and update each cell
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int minAbove = matrix[i - 1][j];

                if (j > 0) {
                    minAbove = Math.min(minAbove, matrix[i - 1][j - 1]);
                }

                if (j < n - 1) {
                    minAbove = Math.min(minAbove, matrix[i - 1][j + 1]);
                }

                matrix[i][j] += minAbove;
            }
        }

        // Find minimum value in the last row
        int minPathSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minPathSum = Math.min(minPathSum, matrix[n - 1][j]);
        }

        return minPathSum;
    }

    public static void main(String[] args) {

    }
}

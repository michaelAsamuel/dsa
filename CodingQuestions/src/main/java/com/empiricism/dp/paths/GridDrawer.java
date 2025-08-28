package com.empiricism.dp.paths;

public class GridDrawer {

    public static void printGrid(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            System.out.println("Grid is empty or null.");
            return;
        }

        int m = grid.length;
        int n = grid[0].length;

        System.out.println("--- Grid ---");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Adjust spacing for better alignment, assuming numbers are single or double digits
                System.out.printf("%4d", grid[i][j]);
            }
            System.out.println(); // New line after each row
        }
        System.out.println("------------");
    }

    public static void main(String[] args) {
        // Example usage with a sample grid
        int[][] grid1 = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        printGrid(grid1);

        int[][] grid2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        printGrid(grid2);
    }
}
package com.empiricism.traversal.dfs;

public class MaxAreaOfIslands {

        private int rows;
        private int cols;
        private int[][] grid;

        public int maxAreaOfIsland(int[][] grid) {
            if (grid == null || grid.length == 0) return 0;
            this.grid = grid;
            this.rows = grid.length;
            this.cols = grid[0].length;

            int maxArea = 0;
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (grid[r][c] == 1) {
                        int area = dfs(r, c);
                        maxArea = Math.max(maxArea, area);
                    }
                }
            }
            return maxArea;
        }

        private int dfs(int r, int c) {
            // Check bounds and whether current cell is land
            if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0) {
                return 0;
            }
            // Mark this cell as visited by setting it to 0
            grid[r][c] = 0;

            int area = 1;  // current cell
            // Explore 4 directions
            area += dfs(r + 1, c);
            area += dfs(r - 1, c);
            area += dfs(r, c + 1);
            area += dfs(r, c - 1);

            return area;
        }


    public static void main(String[] args) {
        MaxAreaOfIslands solver = new MaxAreaOfIslands();

        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        int result = solver.maxAreaOfIsland(grid);
        System.out.println("Max area of island = " + result);
    }


}

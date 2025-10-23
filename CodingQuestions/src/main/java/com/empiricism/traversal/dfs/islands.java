package com.empiricism.traversal.dfs;
//https://leetcode.com/problems/number-of-islands/description/

public class islands {

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) return 0;

            int rows = grid.length;
            int cols = grid[0].length;

            boolean[][] visited = new boolean[rows][cols]; // new visited tracker
            int count = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        count++;
                        dfs(grid, visited, i, j);
                    }
                }
            }
            return count;
        }

        private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
            // Boundary check
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                return;
            }
            // Already visited or water
            if (visited[i][j] || grid[i][j] == '0') {
                return;
            }

            // Mark as visited
            visited[i][j] = true;

            // Explore 4 directions
            dfs(grid, visited, i + 1, j);
            dfs(grid, visited, i - 1, j);
            dfs(grid, visited, i, j + 1);
            dfs(grid, visited, i, j - 1);
        }


}

package com.empiricism.traversal.dfs;

public class MaxAreaOfIslandWithVisited {

    /**
     *  In this example we use instance variables,
     *  so we use fewer variables in our dfs method
     *  Which approach do you prefer?
     */

    private int rows;
    private int cols;
    private int[][] grid;
    private boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.visited = new boolean[rows][cols]; // separate visited array

        int maxArea = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    int area = dfs(r, c);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int r, int c) {
        // boundary or already visited / water
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0 || visited[r][c]) {
            return 0;
        }

        visited[r][c] = true; // mark current cell visited
        int area = 1;

        // explore 4 directions
        area += dfs(r + 1, c); // down
        area += dfs(r - 1, c); // up
        area += dfs(r, c + 1); // right
        area += dfs(r, c - 1); // left

        return area;
    }

    // 👇 Main method to test the solution
    public static void main(String[] args) {
        MaxAreaOfIslandWithVisited solver = new MaxAreaOfIslandWithVisited();

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


package com.empiricism.backtrack;
public class NQueens {

    // Function to print the chessboard
    static void printBoard(int[][] board, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Check if a queen can be safely placed at board[row][col]
    static boolean isSafe(int[][] board, int row, int col, int N) {
        // Check left side of the current row
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower-left diagonal
        for (int i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Recursive utility to solve N-Queens problem
    static boolean solveNQueensUtil(int[][] board, int col, int N) {
        // Base case: All queens are placed
        if (col >= N) {
            printBoard(board, N);
            return true;
        }

        boolean foundSolution = false;

        // Try placing a queen in all rows for this column
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col, N)) {
                board[i][col] = 1; // Place queen

                // Recurse for next column
                foundSolution = solveNQueensUtil(board, col + 1, N) || foundSolution;

                // Backtrack if no solution
                board[i][col] = 0;
            }
        }

        return foundSolution;
    }

    // Main function to solve N-Queens
    static void solveNQueens(int N) {
        int[][] board = new int[N][N];

        if (!solveNQueensUtil(board, 0, N)) {
            System.out.println("No solution exists for " + N + " queens.");
        }
    }

    public static void main(String[] args) {
        int N = 4; // Change this to try other sizes
        System.out.println("Solutions for " + N + "-Queens problem:");
        solveNQueens(N);
    }
}

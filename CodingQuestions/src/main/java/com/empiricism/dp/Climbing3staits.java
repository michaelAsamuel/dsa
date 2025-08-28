package com.empiricism.dp;

public class Climbing3staits {
    public static int countWays(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

//    public static void main(String[] args) {
//        int n = 5;
//        System.out.println("Number of ways to climb " + n + " steps: " + countWays(n));
//    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println("Test Cases for Climbing Stairs Problem:");
        System.out.println("------------------------------------");

        // Test Case 1: n = 0 (Base Case)
//        testCase(0, 1);

        // Test Case 2: n = 1 (Base Case)
//        testCase(1, 1);

        // Test Case 3: n = 2 (Example from problem description)
//        testCase(2, 2);

        // Test Case 4: n = 3 (Example from problem description, corrected expected output)
//        testCase(3, 4);

        // Test Case 5: n = 4
        // Expected: dp[4] = dp[3] + dp[2] + dp[1] = 4 + 2 + 1 = 7
//        testCase(4, 7);

        // Test Case 6: n = 5
        // Expected: dp[5] = dp[4] + dp[3] + dp[2] = 7 + 4 + 2 = 13
//        testCase(5, 13);

        // Test Case 7: n = 10 (Larger input)
        // Expected: Calculated manually or with a known solution (will be larger)
        // dp[6] = 13 + 7 + 4 = 24
        // dp[7] = 24 + 13 + 7 = 44
        // dp[8] = 44 + 24 + 13 = 81
        // dp[9] = 81 + 44 + 24 = 149
        // dp[10] = 149 + 81 + 44 = 274
//        testCase(10, 274);

        // Test Case 8: Negative input (Edge Case - should throw an exception)
//        try {
//            System.out.print("Test Case 8: n = -1 -> ");
//            climbStairs(-1);
//            System.out.println("FAIL (Did not throw IllegalArgumentException)");
//        } catch (IllegalArgumentException e) {
//            System.out.println("PASS (Caught expected exception: " + e.getMessage() + ")");
//        }
//        System.out.println("------------------------------------");
    }

//    public static void testCase(int n, int expected) {
//        int result = climbStairs(n);
//        System.out.print("Test Case: n = " + n + " -> Expected: " + expected + ", Actual: " + result);
//        if (result == expected) {
//            System.out.println(" - PASS");
//        } else {
//            System.out.println(" - FAIL");
//        }
//    }
}

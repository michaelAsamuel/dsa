package com.empiricism.dp;

public class fibonaci {
    public static void main(String[] args) {
        System.out.println(getFinonaci(5));
        System.out.println(getFinonaci(8));
        System.out.println(fibonacciRecursion(5));
        System.out.println(fibonacciRecursion(8));
    }

    public static int getFinonaci(int n){
        if(n==1 || n==2) return 1;

        int[] dp = new int[]{1,1};
        int tmp =0;
        for(int i = 2; i <n; i++){
            tmp = dp[1];
            dp[1] = dp[1] + dp[0];
            dp[0]= tmp;
        }
        return dp[1];

    }
    // Recursive method to find nth Fibonacci number
    public static int fibonacciRecursion(int n) {
        if (n <= 1) {
//            System.out.println("Returning " + n + " from fibonacci(" + n + ")");
            return n; // Base cases: fib(0) = 0, fib(1) = 1
        }
        int result =  fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2); // Recursive formula
//        System.out.println("Returning " + result + " from fibonacci(" + n + ")");
        return result;
    }
}

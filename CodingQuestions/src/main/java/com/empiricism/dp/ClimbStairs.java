package com.empiricism.dp;

public class ClimbStairs {
    public static int climbStairs(int n) {
        //Base case
        if(n<=2) return n;
        // Sub problems
        int first=1,second=2,current=3;
        for(int i=3; i<=n; i++){
            current= first + second;
            first=second;
            second=current;

        }
        return current;

    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3)); // expected 3
        System.out.println(climbStairs(5)); //expected 8
    }
}

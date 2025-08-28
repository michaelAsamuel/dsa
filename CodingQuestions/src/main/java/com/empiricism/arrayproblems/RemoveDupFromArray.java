package com.empiricism.arrayproblems;

import java.util.Arrays;
//Q1) Given an unsorted array. Remove duplicates and return unique elements.
//I/p : ['abc', 'bcd', 'abc', 'dcd']
//O/p: ['abc', 'bcd', 'dcd']

public class RemoveDupFromArray {
    public static void main(String[] args) {
        String[] inp = {"abc", "bcd", "abc", "dcd"};
        System.out.println(Arrays.toString(removeDuplicates(inp)));

    }
    public static String[] removeDuplicates(String[] input) {
        // Step 1: Sort the array
        Arrays.sort(input);

        // Step 2: Use two pointers to remove duplicates in-place
        int n = input.length;
        if (n == 0) return new String[0];

        int slow = 0;

        for (int fast = 1; fast < n; fast++) {
            if (!input[fast].equals(input[slow])) {
                slow++;
                input[slow] = input[fast];
            }
        }

        // Step 3: Return the unique portion
        return Arrays.copyOfRange(input, 0, slow + 1);
    }

}

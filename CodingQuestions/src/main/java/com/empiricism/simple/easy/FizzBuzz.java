package com.empiricism.simple.easy;

import java.util.List;
import java.util.ArrayList;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        // Create a list to hold the results
        List<String> result = new ArrayList<>();

        // Loop from 1 to n inclusive
        for (int i = 1; i <= n; i++) {
            // Use a StringBuilder to build the output string for current number
            StringBuilder sb = new StringBuilder();

            // Check if i is divisible by 3
            if (i % 3 == 0) {
                sb.append("Fizz");
            }

            // Check if i is divisible by 5
            if (i % 5 == 0) {
                sb.append("Buzz");
            }

            // If sb is still empty, it means i is not divisible by 3 or 5
            if (sb.length() == 0) {
                // Convert number to string and add to result
                sb.append(i);
            }

            // Add the resulting string to the result list
            result.add(sb.toString());
        }

        // Return the list with all values
        return result;
    }

    // Example main method to test the fizzBuzz method
    public static void main(String[] args) {
        FizzBuzz solution = new FizzBuzz();
        int n = 15;

        // Call fizzBuzz and get the result list
        List<String> output = solution.fizzBuzz(n);

        // Print the output list
        for (String s : output) {
            System.out.println(s);
        }
    }
}


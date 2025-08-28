package com.empiricism.rabinkarp;

import java.util.List;

public class RabinKarpSearchTest {
    public static void main(String[] args) {
        runTest("GEEKS FOR GEEKS", "GEEK", 101);
        runTest("ABABDABACDABABCABAB", "ABABCABAB", 101);
        runTest("AAAAAAAAAA", "AAA", 101);
        runTest("HELLO WORLD", "XYZ", 101);  // No match
        runTest("PATTERNMATCHING", "PAT", 101);
        runTest("AABAACAADAABAABA", "AABA", 101);  // Overlapping match
    }

    private static void runTest(String text, String pattern, int prime) {
        System.out.println("\nText: \"" + text + "\"");
        System.out.println("Pattern: \"" + pattern + "\"");

        List<Integer> matches = RabinKarpSearch.searchPattern(pattern, text, prime);

        if (matches.isEmpty()) {
            System.out.println("Pattern not found.");
        } else {
            System.out.println("Pattern found at indices: " + matches);
        }
    }
}


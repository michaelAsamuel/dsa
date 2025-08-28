package com.empiricism.rabinkarp;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpSearch {

    private static final int BASE = 256; // Number of characters in the alphabet

    /**
     * Finds and returns the starting indices where the pattern is found in the text.
     *
     * @param pattern The pattern to search for.
     * @param text    The text where the search happens.
     * @param prime   A prime number used for hashing.
     * @return An array of indices where the pattern is found.
     */
    public static List<Integer> searchPattern(String pattern, String text, int prime) {
        List<Integer> matchedIndices = new ArrayList<>();
        int m = pattern.length();
        int n = text.length();

        if (m > n || m == 0 || n == 0) {
            return matchedIndices; // return empty list for invalid input
        }

        int patternHash = 0; // Hash value for the pattern
        int windowHash = 0;  // Hash value for text window
        int highOrderWeight = 1; // BASE^(m-1) % prime

        // Precompute highOrderWeight
        for (int i = 0; i < m - 1; i++) {
            highOrderWeight = (highOrderWeight * BASE) % prime;
        }

        // Compute initial hash values
        for (int i = 0; i < m; i++) {
            patternHash = (BASE * patternHash + pattern.charAt(i)) % prime;
            windowHash = (BASE * windowHash + text.charAt(i)) % prime;
        }

        // Slide the window over the text
        for (int i = 0; i <= n - m; i++) {
            // Check hash match
            if (patternHash == windowHash) {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    matchedIndices.add(i);
                }
            }

            // Update the hash value for the next window
            if (i < n - m) {
                windowHash = (BASE * (windowHash - text.charAt(i) * highOrderWeight)
                        + text.charAt(i + m)) % prime;

                if (windowHash < 0) {
                    windowHash += prime;
                }
            }
        }

        return matchedIndices;
    }
}


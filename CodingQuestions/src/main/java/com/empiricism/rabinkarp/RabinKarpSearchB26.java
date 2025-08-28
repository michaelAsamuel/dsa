package com.empiricism.rabinkarp;
import java.util.*;

public class RabinKarpSearchB26 {


        private static final int BASE = 26; // For lowercase a-z only

        /**
         * Search for a pattern in text using Rabin-Karp optimized for lowercase [a-z]
         *
         * @param pattern The lowercase pattern to search for
         * @param text    The lowercase text where the search happens
         * @param prime   A prime number for modulo hashing
         * @return List of starting indices where pattern is found
         */
        public static List<Integer> searchPattern(String pattern, String text, int prime) {
            List<Integer> matchIndices = new ArrayList<>();
            int m = pattern.length();
            int n = text.length();

            if (m > n || m == 0 || n == 0) {
                return matchIndices;
            }

            int patternHash = 0;
            int textWindowHash = 0;
            int highOrderWeight = 1;

            // Compute highest weight = BASE^(m-1) % prime
            for (int i = 0; i < m - 1; i++) {
                highOrderWeight = (highOrderWeight * BASE) % prime;
            }

            // Compute initial hash values using only 'a'-'z'
            for (int i = 0; i < m; i++) {
                patternHash = (BASE * patternHash + (pattern.charAt(i) - 'a')) % prime;
                textWindowHash = (BASE * textWindowHash + (text.charAt(i) - 'a')) % prime;
            }

            // Slide window
            for (int i = 0; i <= n - m; i++) {
                if (patternHash == textWindowHash) {
                    boolean match = true;
                    for (int j = 0; j < m; j++) {
                        if (text.charAt(i + j) != pattern.charAt(j)) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        matchIndices.add(i);
                    }
                }

                // Update hash for next window
                if (i < n - m) {
                    textWindowHash = (BASE * (textWindowHash - (text.charAt(i) - 'a') * highOrderWeight)
                            + (text.charAt(i + m) - 'a')) % prime;

                    if (textWindowHash < 0) {
                        textWindowHash += prime;
                    }
                }
            }

            return matchIndices;
        }


}

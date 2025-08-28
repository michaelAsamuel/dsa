package com.empiricism.boyermoore;
//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
import java.util.Arrays;

public class NeedleHaystack {


        public int strStr(String haystack, String needle) {
            int m = needle.length();
            int n = haystack.length();

            if (m == 0) return 0;
            if (m > n) return -1;

            int[] badCharTable = buildBadCharTable(needle);
            int shift = 0;

            while (shift <= n - m) {
                int j = m - 1;

                // Compare pattern from end to start
                while (j >= 0 && needle.charAt(j) == haystack.charAt(shift + j)) {
                    j--;
                }

                if (j < 0) {
                    return shift; // Match found
                } else {
                    char badChar = haystack.charAt(shift + j);
                    int lastOccur = badCharTable[badChar];
                    int skip = Math.max(1, j - lastOccur);
                    shift += skip;
                }
            }

            return -1; // No match found
        }

        // Preprocessing: Build the bad character table
        private int[] buildBadCharTable(String pattern) {
            int[] table = new int[256]; // ASCII character set size

            // Initialize all occurrences as -1
            for (int i = 0; i < 256; i++) {
                table[i] = -1;
            }

            // Fill the actual value of last occurrence
            for (int i = 0; i < pattern.length(); i++) {
                table[pattern.charAt(i)] = i;
            }
            System.out.println(Arrays.toString(table));
            return table;
        }

        public static void main(String[] args) {
            NeedleHaystack bm = new NeedleHaystack();
            String haystack = "mississippi";
            String needle = "issip";
            System.out.println(bm.strStr(haystack, needle)); // Output: 4
        }


}

package com.empiricism.boyermoore;


import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/

public class NeedleHaystackMap {




        public int strStr(String haystack, String needle) {
            int m = needle.length();
            int n = haystack.length();

            if (m == 0) return 0;
            if (m > n) return -1;

            Map<Character, Integer> badCharTable = buildBadCharTable(needle);
            int shift = 0;

            while (shift <= n - m) {
                int j = m - 1;

                // COMPARING MATCHES
                while (j >= 0 && needle.charAt(j) == haystack.charAt(shift + j)) {
                    j--;
                }

                if (j < 0) {
                    return shift;  // match found
                } else {
                    char badChar = haystack.charAt(shift + j);
                    int lastOccur = badCharTable.getOrDefault(badChar, -1);
                    int skip = Math.max(1, j - lastOccur);
                    System.out.println(badChar+": "+ skip);
                    shift += skip;
                }
            }

            return -1;
        }

        private Map<Character, Integer> buildBadCharTable(String pattern) {
            Map<Character, Integer> table = new HashMap<>();
            for (int i = 0; i < pattern.length(); i++) {
                table.put(pattern.charAt(i), i);  // store the last occurrence index
            }

            table.forEach((key, value) -> System.out.println(key + ": "+value));
            return table;
        }

        public static void main(String[] args) {
            NeedleHaystackMap bm = new NeedleHaystackMap();
            String haystack = "mississippi";
            String needle = "issip";
//            System.out.println(bm.strStr(haystack, needle));  // Output: 4

            System.out.println(bm.strStr("leetcode", "code"));
        }


}

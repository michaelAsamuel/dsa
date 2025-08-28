package com.empiricism.rabinkarp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RabinKarpTemplate {



    static final int BASE = 256;
    static final long MOD = (1L << 31) - 1; // Large prime to reduce hash collisions

    // Precompute powers of BASE
    public static long[] precomputePowers(int len) {
        long[] pow = new long[len + 1];
        pow[0] = 1;
        for (int i = 1; i <= len; i++) {
            pow[i] = (pow[i - 1] * BASE) % MOD;
        }
        return pow;
    }

    // Get hash of substring s[i..i+length)
    public static long rollingHash(String s, int start, int len, long[] pow) {
        long hash = 0;
        for (int i = 0; i < len; i++) {
            hash = (hash * BASE + s.charAt(start + i)) % MOD;
        }
        return hash;
    }

    // Rabin-Karp to find first match of pattern in text
    public static int rabinKarpSearch(String text, String pattern) {
        int n = text.length(), m = pattern.length();
        if (m > n) return -1;

        long[] pow = precomputePowers(m);
        long targetHash = rollingHash(pattern, 0, m, pow);
        long windowHash = rollingHash(text, 0, m, pow);

        for (int i = 0; i <= n - m; i++) {
            if (i > 0) {
                windowHash = (windowHash + MOD - (text.charAt(i - 1) * pow[m - 1]) % MOD) % MOD;
                windowHash = (windowHash * BASE + text.charAt(i + m - 1)) % MOD;
            }

            if (windowHash == targetHash) {
                if (text.substring(i, i + m).equals(pattern)) {
                    return i;
                }
            }
        }
        return -1;
    }

    // Find all repeated substrings of length k
    public static List<String> findRepeatedSubstrings(String s, int len) {
        Set<Long> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        long[] pow = precomputePowers(len);

        long hash = rollingHash(s, 0, len, pow);
        seen.add(hash);
        for (int i = 1; i <= s.length() - len; i++) {
            hash = (hash + MOD - (s.charAt(i - 1) * pow[len - 1]) % MOD) % MOD;
            hash = (hash * BASE + s.charAt(i + len - 1)) % MOD;

            String sub = s.substring(i, i + len);
            if (seen.contains(hash)) {
                duplicates.add(sub);
            }
            seen.add(hash);
        }
        return new ArrayList<>(duplicates);
    }

    // Binary search + Rabin-Karp for longest duplicate substring
    public static String longestDuplicateSubstring(String s) {
        int left = 1, right = s.length();
        int start = -1, maxLen = 0;
        long[] pow = precomputePowers(s.length());

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int idx = checkDuplicateSubstring(s, mid, pow);
            if (idx != -1) {
                left = mid + 1;
                start = idx;
                maxLen = mid;
            } else {
                right = mid - 1;
            }
        }
        return start != -1 ? s.substring(start, start + maxLen) : "";
    }

    private static int checkDuplicateSubstring(String s, int len, long[] pow) {
        Set<Long> seen = new HashSet<>();
        long hash = rollingHash(s, 0, len, pow);
        seen.add(hash);
        for (int i = 1; i <= s.length() - len; i++) {
            hash = (hash + MOD - (s.charAt(i - 1) * pow[len - 1]) % MOD) % MOD;
            hash = (hash * BASE + s.charAt(i + len - 1)) % MOD;
            if (seen.contains(hash)) return i;
            seen.add(hash);
        }
        return -1;
    }

    // ---------- Test Methods ----------
    public static void testSearch() {
        String text = "mississippi";
        String pattern = "issi";
        int index = rabinKarpSearch(text, pattern);
        System.out.println("Pattern found at index: " + index);
    }

    public static void testRepeatedSubstrings() {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> repeats = findRepeatedSubstrings(s, 10);
        System.out.println("Repeated 10-letter substrings: " + repeats);
    }

    public static void testLongestDuplicate() {
        String s = "banana";
        String result = longestDuplicateSubstring(s);
        System.out.println("Longest Duplicate Substring: " + result);
    }

    public static void main(String[] args) {
        testSearch();               // Leetcode 28
        testRepeatedSubstrings();   // Leetcode 187
        testLongestDuplicate();     // Leetcode 1044
    }


}

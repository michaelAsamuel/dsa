package com.empiricism.hard;
//https://leetcode.com/problems/palindromic-substrings/
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expandAroundCenter(s, i, i);     // Odd length palindromes
            count += expandAroundCenter(s, i, i + 1); // Even length palindromes
        }
        return count;

    }

    // This generic method can be used for all palindrome problems with slight modification
    private int expandAroundCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;  // A single letter is a Palindrome of size 1
            left--;
            right++;
        }
        return count;
    }
}

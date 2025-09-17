package com.empiricism.hard;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/longest-palindromic-substring/submissions/1623402388/
//https://leetcode.com/problems/palindromic-substrings/description/
//https://leetcode.com/problems/longest-palindromic-substring/description/
public class LongestPalindromeSubstring {
    public static String longestPalindromeSubstring(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome
            int left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            int len1 = right - left - 1;

            // Even length palindrome
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            int len2 = right - left - 1;

            int len = Math.max(len1, len2);
            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);

    }



    public static void main(String[] args) {

        String s = "babad";
        System.out.println(longestPalindromeSubstring(s));
        s="cbccbd";
        System.out.println(longestPalindromeSubstring(s));
        s="c";
        System.out.println(longestPalindromeSubstring(s));
        s="";
        System.out.println(longestPalindromeSubstring(s));




    }
}

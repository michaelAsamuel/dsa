package com.empiricism.slidwin;
//    https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/1690483477/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // expected 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // expected 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // expected 3

        System.out.println(lengthOfLongestSubstringSet("abcabcbb")); // expected 3
        System.out.println(lengthOfLongestSubstringSet("bbbbb")); // expected 1
        System.out.println(lengthOfLongestSubstringSet("pwwkew")); // expected 3

    }

    static int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128];  // For all ASCII characters
        Arrays.fill(lastSeen, -1);      // Initialize each character as not seen

        int maxLen = 0;  // To store the max length
        int start = 0;   // Start index of the current window

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            // If character is already seen in the current window
            if (lastSeen[c] >= start) {
                start = lastSeen[c] + 1;  // Move start to the next character
            }

            lastSeen[c] = end;  // Update the last seen index of the current character
            maxLen = Math.max(maxLen, end - start + 1);  // Update max length
        }

        return maxLen;
    }
    static int lengthOfLongestSubstringSet(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0, right = 0, maxLen = 0;

        while (right < s.length()) {
            char c = s.charAt(right);

            if (!seen.contains(c)) {
                seen.add(c);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                seen.remove(s.charAt(left));
                left++;
            }
        }

        return maxLen;
    }


}

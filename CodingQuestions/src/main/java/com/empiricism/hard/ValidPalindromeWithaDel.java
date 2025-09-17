package com.empiricism.hard;

public class ValidPalindromeWithaDel {
    static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Since you can delete only 1 character. Try removing either the left or right character
                return isPalindromeRange(s, left + 1, right)
                        || isPalindromeRange(s, left, right - 1);
            }
            left++;
            right--;
        }

        return true; // Already a palindrome
    }

    private static boolean isPalindromeRange(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("aba"));;
        System.out.println(validPalindrome("abca"));;
        System.out.println("abc");
    }
}

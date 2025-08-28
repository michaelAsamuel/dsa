package com.empiricism.base;

public class Palindrome {

    public static void main(String[] args) {
        String str = "madam";
        System.out.println("Is Palindrome: " + isPalindromeByEnds(str));
        System.out.println("Is Palindrome: " + isPalindromeByMiddle(str));
    }

    public static boolean isPalindromeByEnds(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            // Compare characters at both ends
            if (str.charAt(left) != str.charAt(right)) {
                return false;  // Not a palindrome if characters mismatch
            }
            left++;
            right--;
        }
        return true;  // Palindrome if all characters match
    }


    public static boolean isPalindromeByMiddle(String str) {
        int n = str.length();
        int mid = n / 2;

        // For odd length, start at mid+1 for right; for even length, start directly
        int left = mid - 1;
        int right = (n % 2 == 0) ? mid : mid + 1;

        // Move outward from the middle, comparing characters
        while (left >= 0 && right < n) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;  // Not a palindrome if characters mismatch
            }
            left--;
            right++;
        }
        return true;  // Palindrome if all characters match
    }

}







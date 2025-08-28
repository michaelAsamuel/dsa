package com.empiricism.base;

import java.util.HashSet;

public class ReverseVowels {

    // Helper function to check if a character is a vowel
    public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        return vowels.contains(ch);
    }

    // Function to reverse only the vowels in a string
    public static String reverseVowels(String str) {
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            // Find the next vowel from the left
            while (left < right && !isVowel(charArray[left])) {
                left++;
            }

            // Find the next vowel from the right
            while (left < right && !isVowel(charArray[right])) {
                right--;
            }

            // Swap the vowels
            if (left < right) {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;

                // Move the pointers inward
                left++;
                right--;
            }
        }

        return new String(charArray);
    }

    public static void main(String[] args) {
        String str = "hello world";
        str="rdfsaeb";
        System.out.println("Original String: " + str);
        System.out.println("Reversed Vowels String: " + reverseVowels(str));

    }
}

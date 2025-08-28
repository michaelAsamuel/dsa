package com.empiricism.base;

public class ReverseString {

    public static String reverseByEnds(String str) {
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            // Swap the characters
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            // Move the pointers toward the center
            left++;
            right--;
        }

        return new String(charArray);
    }

    public static void main(String[] args) {
        String str = "HelloWorld";
        System.out.println(str + "-> Reversed String: " + reverseByEnds(str));
    }

}



package com.empiricism.arrayproblems;

import java.util.Arrays;

public class StringCompression {
    static int Compress(char[] chars) {
        char currChar = chars[0];
        int cnt = 0;
        int result = 0;
        int write = 0;
        for (char c : chars) {
            if (c == currChar) {
                cnt++;
            } else {
                chars[write] = currChar;
                write++;
                result++;
                if (cnt > 1) {
                   for(char cn: String.valueOf(cnt).toCharArray()){
                            chars[write]=cn;
                            write++;
                            result++;
                   }

                }

                currChar = c;
                cnt = 1;
            }
        }

        chars[write] = currChar;
        write++;
        result++;
        if (cnt > 1) {
            for(char cn: String.valueOf(cnt).toCharArray()){
                chars[write]=cn;
                write++;
                result++;
            }
        }
        System.out.println(Arrays.toString(chars));
        return result;

    }

    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
//        System.out.println(Compress(chars));
        System.out.println(Compress(new char[]{'a','a','a','a','a','a','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','c','c','c','c','c','c','c','c','c','c','c','c','c','c'}));
//        System.out.println(compressAI(new char[]{'a','a','a','a','a','a','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','c','c','c','c','c','c','c','c','c','c','c','c','c','c'}));
    }

    static int compressAI(char[] chars) {

        int index = 0; // Position to write the compressed character
        int i = 0;     // Read pointer

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // Count occurrences of the current character
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            // Write the character
            chars[index++] = currentChar;

            // Write the count if more than 1
            if (count > 1) {
                // For loop required to write cnt more than 1 digit
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }
        System.out.println(chars);
        return index;
    }
}

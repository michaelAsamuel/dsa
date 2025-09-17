package com.empiricism.arrayproblems;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {

        int[] lastIndex = new int[26]; // last occurrence of each character
        boolean[] seen = new boolean[26]; // whether character is in the result
        Stack<Character> stack = new Stack<>();

        // Record the last index of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';

            if (seen[idx]) continue;

            // Remove characters that are greater than current and appear later
            while (!stack.isEmpty() && c < stack.peek() && i < lastIndex[stack.peek() - 'a']) {
                seen[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            seen[idx] = true;
        }

        // Build the result string
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();


    }
}

package com.empiricism.simple.easy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CharCount {
    public static String countChars(String input){
        Map<Character, Integer> charMap = new LinkedHashMap<>();
        char[] arr = input.toCharArray();

        for (char c : arr) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        StringBuilder output = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            output.append(entry.getKey()).append(entry.getValue());
        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(countChars("aabbbhhcc"));
        System.out.println(countChars("aaaa"));
        System.out.println(countChars("a"));
        System.out.println(countChars("aabbbab"));

    }
}

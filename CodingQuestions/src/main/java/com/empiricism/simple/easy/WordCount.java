package com.empiricism.simple.easy;

import java.util.LinkedHashMap;
import java.util.Map;

/*
Convert a string as given in the format below:

Example:
aabbb into a2b3
aaaa into a4
a into a1
 */

/*
1. Don't make assumptions clarify if the alphabets are ordered or if they appear together
2. Confirm if only alphabets
 */
public class WordCount {
    public static void main(String[] args) {
        System.out.println(countWords("aabbb"));
        System.out.println(countWords("aabbabccccaffdd"));

    }

    public static String countWords(String s){
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(var entry: map.entrySet()){
            sb.append(entry.getKey());
            sb.append(entry.getValue());
        }
        return sb.toString();

    }
}

package com.empiricism;

import java.util.HashMap;
import java.util.Map;

public class PermutationsInaString {
    public static void main(String[] args){
        System.out.println(isPermutation("ab","eidbaooo"));
        System.out.println(isPermutation("ab","abc"));
        System.out.println(isPermutation("ab","eidbxaooo"));

    }

    public static  boolean isPermutation(String s1, String s2){
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        Map<Character, Integer> subMap = new HashMap<Character, Integer>();

        for(char c: s1.toCharArray()){
            if(charMap.containsKey(c)){
                charMap.put(c, charMap.get(c)+1);
            }else {
                charMap.put(c, 1);
            }
        }

        for(int i=0; i< s1.length(); i++){
            char c = s2.charAt(i);
            if(subMap.containsKey(c)){
                subMap.put(c, subMap.get(c)+1);
            }else {
                subMap.put(c, 1);
            }
        }
        // Compare
        if(checkOccurrence(charMap, subMap)){
            return true;
        }
        System.out.println(charMap);
        System.out.println(subMap);
        for(int i=1; i< s2.length()-s1.length(); i++){
            char charAdded = s2.charAt(i+s1.length()-1);
            char charRemoved = s2.charAt(i-1);


            // Add new Character
            if(subMap.containsKey(charAdded)){
                subMap.put(charAdded, subMap.get(charAdded)+1);
            }else {
                subMap.put(charAdded, 1);
            }
            //Remove old character
            if(subMap.containsKey(charRemoved) && subMap.get(charRemoved)> 1){
                subMap.put(charAdded, subMap.get(charAdded)-1);
            }else{
                subMap.remove(charRemoved);
            }
            // Compare
            if(checkOccurrence(charMap, subMap)){
                return true;
            }
        }

        return false;

    }

    private static boolean checkOccurrence(Map<Character, Integer> target, Map<Character, Integer> subMap){

        for (Map.Entry<Character, Integer> entry : target.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (value != subMap.getOrDefault(key, 0)) {
                return false;
            }
        }
        return true;

    }
}

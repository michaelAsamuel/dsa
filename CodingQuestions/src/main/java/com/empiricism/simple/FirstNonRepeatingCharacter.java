package com.empiricism.simple;
// 387. First Unique Character in a String
public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("12345"));
        System.out.println(firstUniqChar("abbacd"));

    }


    public static int firstUniqChar(String s) {
        int[] freq = new int[256];
        for(char c: s.toCharArray()){
            freq[c]++;
        }
        for(int i =0; i< s.length(); i++){
            if(freq[s.charAt(i)]==1){
                return s.charAt(i);
            }
        }
        return -1;

    }
}

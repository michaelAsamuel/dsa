package com.empiricism.hard;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/longest-palindrome/description/
public class LongestPalindrome {
    public static String longestPalindromeSubstring(String s) {
        String res = "";
        int maxLength =0;
        for(int i=0; i < s.length() ; i++){
            int l=i, r=i;

            while(l >0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > maxLength) {
                    maxLength = r - l + 1;
                    res=s.substring(l,r);
                }
                l--;
                r++;
            }

            l=i;
            r=i+1;
            while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > maxLength) {
                    maxLength = r - l + 1;
                    res=s.substring(l,r);
                }
                l--;
                r++;
            }

            System.out.println(res);

        }
        return res;
    }

    public static int longestPalindrome(String s) {

    Map<Character, Integer> charCount = new HashMap<>();
    int result =0;
    for(int i=0; i< s.length(); i++){
        if(charCount.containsKey(s.charAt(i))){
            charCount.put(s.charAt(i),charCount.get(s.charAt(i))+1);
        }else {
            charCount.put(s.charAt(i),1);
        }
    }
    int odd =0;
    for(Map.Entry<Character, Integer> entry  : charCount.entrySet()){
        if(entry.getValue()%2==0){
            result += entry.getValue();
        }else{
            result += entry.getValue()-1;
            odd=1;
        }
    }
    return result+odd;

    }

    public static int longestPalindromeTwo(String s) {
        Set<Character> tmpset = new HashSet<>();
        int result =0;
        for(int i=0; i<s.length();i++){
            if(tmpset.contains(s.charAt(i))){
                result += 2;
                tmpset.remove(s.charAt(i));
            }else{
                tmpset.add(s.charAt(i));
            }
        }
        if(tmpset.size()>0){
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
//        String s = "abccccdd";
//        System.out.println(longestPalindrome(s));
//        s="ccc";
//        System.out.println(longestPalindrome(s));

        String s = "babad";
        System.out.println(longestPalindromeSubstring(s));


    }
}

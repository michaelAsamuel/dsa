package com.empiricism.hard;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/longest-palindromic-substring/submissions/1623402388/
//https://leetcode.com/problems/palindromic-substrings/description/
public class LongestPalindromeSubstring {
    public static String longestPalindromeSubstring(String s) {
        String res = "";
        int maxLength =0;
        for(int i=0; i < s.length() ; i++){

//            ODD
            int l=i, r=i;

            while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > maxLength) {
                    maxLength = r - l + 1;
                    res=s.substring(l,r+1);
                }
                l--;
                r++;
            }
//          even
            l=i;
            r=i+1;
            while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > maxLength) {
                    maxLength = r - l + 1;
                    res=s.substring(l,r+1);
                }
                l--;
                r++;
            }



        }
        return res;
    }

//    https://leetcode.com/problems/longest-palindromic-substring/
    public int countSubstrings(String s) {
        int res = 0;
        int maxLength =0;
        for(int i=0; i < s.length(); i++){
            // ODD
            int l=i, r=i;
            while(l>=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                res++;
                l--;
                r++;
            }

            // Even
            l=i; r=i+1;
            while(l>=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                res++;
                l--;
                r++;
            }

        }
        return res;

    }



    public static void main(String[] args) {

        String s = "babad";
        System.out.println(longestPalindromeSubstring(s));
        s="cbccbd";
        System.out.println(longestPalindromeSubstring(s));
        s="c";
        System.out.println(longestPalindromeSubstring(s));
        s="";
        System.out.println(longestPalindromeSubstring(s));



    }
}

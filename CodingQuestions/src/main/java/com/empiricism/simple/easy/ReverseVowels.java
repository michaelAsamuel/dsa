package com.empiricism.simple.easy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ReverseVowels {

    public static void main(String[] args) {

        System.out.println( reverseVowels("IceCreAm") );
        System.out.println( reverseVowels("Centricity") );
        System.out.println( reverseVowels("Solidarity") );
        System.out.println( reverseVowels("Maldives") );
    }
    public static String reverseVowels(String s) {
        char[] carr = s.toCharArray();
        String vowels = "aeiouAEIOU";
        for(int i=0, j= s.length()-1; i<j ; i++, j--){
           // while( i < j && !isvowel(s.toLowerCase().charAt(i))){
            while(i<j && vowels.indexOf(s.charAt(i))<0){
                i++;
            }
            //while( i < j && !isvowel(s.toLowerCase().charAt(j))){
           while(i<j && vowels.indexOf(s.charAt(j))<0){
                j--;
            }
            char tmp = carr[i];
            carr[i] = carr[j];
            carr[j] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for(char c: carr) sb.append(c);

        return sb.toString();

    }

//    private static boolean isvowel(char c){
//
//        if(c == 'a' || c=='e' || c=='i' ||c=='o' || c=='u') return true;
//        else return false;
//    }

}

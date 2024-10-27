package com.empiricism.simple;

/* "Given a dictionary (list of words) and a substring, you have to return the length of the longest word in the dictinary containing the substring.
Example:
String[] dict = {""CODGE"", ""ODG"", ""LODGES"", ""SODG"", ""dodge"", ""mODJ"", ""LODGESSSS""}
String toSearch = ""ODG"";
//Returns 9 (LODGESSSS)"
*/

public class LongestWord {
    public static void main(String[] args) {
        String[] input = {"CODGE", "ODG", "LODGES", "SODG", "dodge", "mODJ", "LODGESSSS"};
//        System.out.println(getLongestWord(input, "ODG"));
//        System.out.println(getLongestWord(input, "COD"));
//        System.out.println(isSubstringThere("CODGE", "ODG"));
//        System.out.println(isSubstringThere("dodge", "ODG"));
//          System.out.println(isSubstringThere("dodge", "COD"));
         System.out.println(isSubstringThere("LODGES", "COD"));
//        String[] input = {"CODGE", "ODG", "LODGES", "SODG", "dodge", "mODJ", "LODGESSSS"};
        System.out.println(getLongestWord2(input, "ODG"));
        System.out.println(getLongestWord2(input, "COD"));


    }

    public static int getLongestWord(String[] input, String sub){
        int result =0;
        for( String s: input){
            if(s.contains(sub)){
                result = Math.max(result, s.length());
            }

        }
        return result;
    }

    public static int getLongestWord2(String[] input, String sub){
        int result =0;
        for( String s: input){
            if(isSubstringThere(s, sub)){
                result = Math.max(result, s.length());
            }

        }
        return result;
    }

    // Write a method to see if String s1 contains String s2
    public static boolean isSubstringThere(String s, String sub){
        char[] carr = s.toCharArray();
        int subIndex = 0;
        int startIndex =0;
        for(int i = 0; i < carr.length; i++){
            if( s.charAt(i)!= sub.charAt(subIndex)){
                subIndex = 0;
                startIndex++;
            }else {
                subIndex++;
            }
            if(subIndex == sub.length()) return true;
        }
        return false;

    }



}

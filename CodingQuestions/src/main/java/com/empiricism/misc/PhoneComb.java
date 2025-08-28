package com.empiricism.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
public class PhoneComb {

    public static void main(String[] args) {

        System.out.println(letterCombinations("2358"));
//        System.out.println(letterCombinations1("23"));
    }
    public static List<StringBuilder> letterCombinations(String digits) {

        List<StringBuilder> result = new ArrayList<>();

        Map<Character, String> phone = new HashMap<>();
        phone.put('2',"abc");
        phone.put('3', "def");
        phone.put('4', "ghi");
        phone.put('5', "jkl");
        phone.put('6', "mno");
        phone.put('7', "pqrs");
        phone.put('8', "tvu");
        phone.put('9', "wxyz");
        phone.put('0', "0");
        phone.put('1',"1");

        List<StringBuilder> sbl = new ArrayList<>();
        if(digits.length()>0){
            char c =  digits.charAt(0);
            char[] ca = phone.get(c).toCharArray();
            for(char ch: ca){
                result.add(new StringBuilder().append(ch));
            }
        }else{
            return result;
        }

        for(int i=1; i<digits.length(); i++ ){
            result = addNumber(result, phone.get(digits.charAt(i)).toCharArray());
            System.out.println(result);
        }

        return result;


    }

    // Iteratively add the new characters
     private static List<StringBuilder> addNumber(List<StringBuilder> prevList, char[] ca){
         List<StringBuilder> result = new ArrayList<>();
        for(StringBuilder sb: prevList) {
            for(char ch: ca){
                StringBuilder sbCurr = new StringBuilder();
                sbCurr.append(sb).append(ch);
                result.add(sbCurr);
            }
        }
        return result;
     }



//     --------------------------
public static List<String> letterCombinations1(String digits) {

    List<String> result = new ArrayList<>();

    Map<Character, String> phone = new HashMap<>();
    phone.put('2', "abc");
    phone.put('3', "def");
    phone.put('4', "ghi");
    phone.put('5', "jkl");
    phone.put('6', "mno");
    phone.put('7', "pqrs");
    phone.put('8', "tvu");
    phone.put('9', "wxyz");
    phone.put('0', "0");
    phone.put('1', "1");

    List<Character> sbl = new ArrayList<>();
    if (digits.length() > 0) {
        char c = digits.charAt(0);
        char[] ca = phone.get(c).toCharArray();
        for (char ch : ca) {
            result.add(String.valueOf(ch));
        }
    } else {
        return result;
    }

    for (int i = 1; i < digits.length(); i++) {
        result = addNumber1(result, phone.get(digits.charAt(i)).toCharArray());

    }

    return result;
}
    private static List<String> addNumber1(List<String> prevList, char[] ca){
        List<String> result = new ArrayList<>();
        for(String sb: prevList) {
            for(char ch: ca){
                result.add(sb.concat(String.valueOf(ch)));
            }
        }
        return result;
    }


}

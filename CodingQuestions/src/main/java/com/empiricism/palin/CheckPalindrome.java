package com.empiricism.palin;

public class CheckPalindrome {
    public static void main(String[] args) {
        System.out.println(chekFromEnds("racecar"));
        System.out.println(chekFromEnds("raccar"));
        System.out.println(chekFromEnds("racsdcar"));
        System.out.println(checkFromMiddle("racecar"));
        System.out.println(checkFromMiddle("raccar"));
        System.out.println(checkFromMiddle("racedcar"));
        System.out.println(checkFromMiddle("racecard"));
        System.out.println(checkFromMiddle("aracecar"));
    }

    public static boolean chekFromEnds(String s){
        for(int i=0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt((s.length()-i)-1))
                return false;
        }
        return true;
    }

    public static boolean checkFromMiddle(String s){
        int left = (s.length()/2) -1;
        int right = s.length()-1-left;
        while(left >= 0){
            if(s.charAt(left)!= s.charAt(right)){
                return false;
            }
            left--;
            right++;
        }
        return true;


    }
}

package com.empiricism.basicmaths;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(checkPalindrome(121));
        System.out.println(checkPalindrome(7));
        System.out.println(checkPalindrome(1212));
        System.out.println(checkPalindrome(999));

    }

    static boolean checkPalindrome(int num){

        int result =0;
        int num1 = num;
        while(num1 > 0){
            result = result *10 + num1%10;
            num1 = num1/10;
        }
        return result==num;

    }
}

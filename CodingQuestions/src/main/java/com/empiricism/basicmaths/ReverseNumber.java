package com.empiricism.basicmaths;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println( reverseNum(7789));
    }

    static int reverseNum(int num){
        int result =0;
        while(num > 0){
            result = result *10 + num%10;
            num = num/10;
        }
        return result;


    }
}

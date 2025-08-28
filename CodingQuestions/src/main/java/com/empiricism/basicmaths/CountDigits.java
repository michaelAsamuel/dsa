package com.empiricism.basicmaths;

public class CountDigits {

    public static void main(String[] args) {
        System.out.println(countDigits(1234784));

    }

    static int countDigitsLog(int num){
        int cnt = (int) Math.log10(num) +1;
        return cnt;
    }


    static int countDigits(int num){
        int cnt=0;
        while(num > 0){
            num = num/10;
            cnt++;

        }
        return cnt;
    }
}

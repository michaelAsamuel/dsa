package com.empiricism.simple.beginner;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(basicLengthCompression("aaabbcccdjhh"));

    }
    public int getLengthOfOptimalCompression(String s, int k) {
        return 1;

    }

    public static String basicLengthCompression(String s){
        StringBuilder sb = new StringBuilder();
        char prevChar= s.charAt(0);
        int cnt =0;
        for(int i=0; i < s.length(); i++){
            if(prevChar == s.charAt(i)){
                cnt++;
            }else{
                sb.append(prevChar);
                if(cnt>1){
                    sb.append(cnt);
                }
                prevChar=s.charAt(i);
                cnt=1;

            }
        }
        return sb.toString();
    }
}

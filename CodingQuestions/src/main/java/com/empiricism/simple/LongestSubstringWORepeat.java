package com.empiricism.simple;

public class LongestSubstringWORepeat {
    public static void main(String[] args) {
        System.out.println(getLongest("ABCBC"));
        System.out.println(getLongest("ABCBJKLC"));
        System.out.println(getLongest("GEEKSFORGEEKS"));

    }

    public static  int getLongest(String s){
        int[] freq = new int[256];
        int startIndex =1;
        int currIndex =0;
        int maxLength =0;
        int count=0;
        for(int i=1; i<s.length(); i++){
            char c = s.charAt(i-1);
            if(freq[c] >= startIndex){
                if(maxLength < count){
                    maxLength=count;

                }

                startIndex=freq[c]+1;
                count = i-startIndex;


            }
            freq[c] =i;
            count++;
        }
        System.out.println("-----");
        System.out.println(count);

        return Math.max(maxLength,count);
    }
}

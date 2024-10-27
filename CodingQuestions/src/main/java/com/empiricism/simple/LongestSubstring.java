package com.empiricism.simple;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestSubstring {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(getLongest("aabbbbbCdAAdddddddd")));
        System.out.println(Arrays.toString(getLongest("aabbbbCCddd")));
        System.out.println(Arrays.toString(getLongest("10000111")));
        System.out.println(Arrays.toString(getLongest("c")));
        System.out.println(Arrays.toString(getLongest("")));


       longestSubstring("aabbbbbCdAAdddddddd");
        longestSubstring("aabbbbCCddd");
        longestSubstring("10000111");
        longestSubstring("c");
        longestSubstring("");

    }

    public static int[] getLongest(String s) {

        // Boundary Condition
        if (s.length() == 0) return new int[]{-1, 0};

        int longestIndex = 0;
        int longestCount = 0;
        int cnt = 0;
        char currChar = s.charAt(0);
        int currIndex = 0;



        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != currChar) {
                if (cnt > longestCount) {
                    longestIndex = currIndex;
                    longestCount = cnt;
                }
                currChar = c;
                cnt = 1;
                currIndex = i;
            } else {
                cnt++;
            }
        }
        if (cnt > longestCount) {
            longestCount = cnt;
            longestIndex = currIndex;
        }
        int[] result = {longestIndex, longestCount};
        return result;

    }


    private static void longestSubstring(String s) {
        //if (s.length() == 0) return new int[]{-1, 0};
        int count = 1;
        int max = 0;
        int longestIndex=0;
        int index = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                if (count > max) {
                    max =  count;
                    longestIndex=index;
                }
                index = i;
                count = 1;
            }
        }
        if (count > max) {
            max =  count;
            longestIndex=index;

        }
        System.out.println(longestIndex + "  " + max);
    }
}

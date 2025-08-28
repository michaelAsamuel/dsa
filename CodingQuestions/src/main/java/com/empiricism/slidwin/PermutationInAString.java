package com.empiricism.slidwin;

import java.util.Arrays;

public class PermutationInAString {

    /**
     *  The window should be same size as s1
     *  Freq should be same
     *  Arrays.equals allowed
     */
    static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] freqW = new int[26];
        int[] freqS1 = new int[26];
        int x= s1.length();
        for(int i=0 ; i< s1.length(); i++){
            freqS1[s1.charAt(i)-'a']++;
            freqW[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(freqS1,freqW)) return true;

        for(int i=s1.length(); i<s2.length(); i++){
            freqW[s2.charAt(i-x)-'a']--;
            freqW[s2.charAt(i)-'a']++;
            if(Arrays.equals(freqS1,freqW)) return true;
        }
        return false;

    }

    public boolean areArraysEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println("Expected: true: "+checkInclusion("ab", "eidbaooo"));
        System.out.println("Expected: false: "+checkInclusion("ab", "eidboaoo"));
        System.out.println("Expected: true: "+checkInclusion("adc", "dcda"));
        System.out.println("Expected: false: "+checkInclusion("adc", "a"));

    }


}

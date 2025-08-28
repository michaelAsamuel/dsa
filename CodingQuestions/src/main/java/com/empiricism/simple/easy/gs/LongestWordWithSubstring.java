package com.empiricism.simple.easy.gs;

public class LongestWordWithSubstring {
    public static void main(String[] args) {
        String[] dict = {"CODGE", "ODG", "LODGES", "SODG", "dodge", "mODJ", "LODGESSSS"};
        System.out.println(longestWordWithSubstringManual(dict,"ODG"));
        System.out.println(longestWordWithSubstringManual(dict,"mOD"));
        System.out.println(longestWordWithSubstringSlidingWindow(dict,"ODG"));
        System.out.println(longestWordWithSubstringSlidingWindow(dict,"mOD"));
    }
    public static int longestWordWithSubstringManual(String[] dict, String toSearch) {
        int maxLength = 0;
        for (String word : dict) {
            if (containsSubstring(word, toSearch)) {
                maxLength = Math.max(maxLength, word.length());
            }
        }
        return maxLength;
    }

    private static boolean containsSubstring(String word, String toSearch) {
        int wLen = word.length();
        int sLen = toSearch.length();

        if (sLen > wLen) return false;

        for (int i = 0; i <= wLen - sLen; i++) {
            int j = 0;
            while (j < sLen && word.charAt(i + j) == toSearch.charAt(j)) {
                j++;
            }
            if (j == sLen) return true;
        }
        return false;
    }

    public static int longestWordWithSubstringSlidingWindow(String[] dict, String toSearch) {
        int maxLength = 0;
        int sLen = toSearch.length();

        for (String word : dict) {
            if (word.length() < sLen) continue; // skip if word too short

            boolean found = false;
            for (int i = 0; i <= word.length() - sLen; i++) {
                String window = word.substring(i, i + sLen);
                if (window.equals(toSearch)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                maxLength = Math.max(maxLength, word.length());
            }
        }

        return maxLength;
    }


}

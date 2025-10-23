package com.empiricism.dp.wordbreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakDP {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true; // base case: empty string is valid

        // iterate backwards
        for (int i = n - 1; i >= 0; i--) {
            for (String word : dict) {
                int len = word.length();
                if (i + len <= n && s.startsWith(word, i)) {
                    if (dp[i + len]) {
                        dp[i] = true;
                        break; // no need to check more words
                    }
                }
            }
        }
        return dp[0];

    }
}

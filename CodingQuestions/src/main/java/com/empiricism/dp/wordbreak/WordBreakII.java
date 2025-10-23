package com.empiricism.dp.wordbreak;

//https://leetcode.com/problems/word-break-ii/

import java.util.*;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return dfs(s, dict, memo);

    }

    private List<String> dfs(String s, Set<String> dict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);

        List<String> results = new ArrayList<>();

        if (s.isEmpty()) {
            results.add("");
            return results;
        }

        for (String word : dict) {
            if (s.startsWith(word)) {
                String suffix = s.substring(word.length());
                List<String> subs = dfs(suffix, dict, memo);

                for (String sub : subs) {
                    if (sub.isEmpty()) {
                        results.add(word);
                    } else {
                        results.add(word + " " + sub);
                    }
                }
            }
        }

        memo.put(s, results);
        return results;
    }
}

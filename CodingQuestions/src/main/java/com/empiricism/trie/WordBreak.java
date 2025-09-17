package com.empiricism.trie;

import java.util.*;

public class WordBreak {
        public List<String> wordBreak(String s, List<String> wordDict) {
            Set<String> dict = new HashSet<>(wordDict);
            Map<Integer, List<String>> memo = new HashMap<>();
            return dfs(s, 0, dict, memo);
        }

        private List<String> dfs(String s, int start,
                                 Set<String> dict,
                                 Map<Integer, List<String>> memo) {
            if (memo.containsKey(start)) {
                return memo.get(start);
            }

            List<String> result = new ArrayList<>();

            if (start == s.length()) {
                // One valid segmentation: empty sentence
                result.add("");
            } else {
                for (int end = start + 1; end <= s.length(); end++) {
                    String word = s.substring(start, end);
                    if (dict.contains(word)) {
                        List<String> subs = dfs(s, end, dict, memo);
                        for (String sub : subs) {
                            String sentence = sub.isEmpty() ? word
                                    : word + " " + sub;
                            result.add(sentence);
                        }
                    }
                }
            }

            memo.put(start, result);
            return result;
        }


}

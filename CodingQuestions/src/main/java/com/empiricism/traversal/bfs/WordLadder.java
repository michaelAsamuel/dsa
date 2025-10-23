package com.empiricism.traversal.bfs;

import java.util.*;

public class WordLadder {

    /**
     * Returns the length of the shortest transformation sequence from beginWord to endWord.
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Convert wordList to HashSet for fast lookup
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0; // endWord must be in the list

        // Queue for BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord); // start BFS from beginWord

        int level = 1; // level = number of transformations

        // BFS loop
        while (!queue.isEmpty()) {
            int size = queue.size(); // number of words at current level
            for (int i = 0; i < size; i++) {
                String word = queue.poll(); // get the front word

                // Try all possible one-letter transformations
                for (int j = 0; j < word.length(); j++) {
                    char[] wordArray = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        wordArray[j] = ch;
                        String newWord = new String(wordArray);

                        // If we reach endWord, return the number of transformations
                        if (newWord.equals(endWord)) return level + 1;

                        // If newWord is valid, add to queue and remove from set
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord); // mark as visited
                        }
                    }
                }
            }
            level++; // increase transformation level after processing current level
        }

        return 0; // no transformation sequence found
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        WordLadder solver = new WordLadder();
        int result = solver.ladderLength(beginWord, endWord, wordList);

        System.out.println("Length of shortest transformation sequence: " + result);
    }
}


package com.empiricism.trie;

class TrieNode {
    TrieNode[] children = new TrieNode[26]; // a to z
    boolean isEndOfWord = false;
}


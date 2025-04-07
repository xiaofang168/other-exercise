package com.fangj.exercise.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangjie
 * @date 2025/4/7 10:35
 */
public class TrieKeywordReplacer  {

    private final Trie trie;
    public String replaceKeywords(String text) {
        return trie.replaceKeywords(text, "");
    }

    public TrieKeywordReplacer(String keyWords) {
        Trie trie = new Trie();
        for (String s : keyWords.split(";")) {
            trie.insert(s);
        }
        this.trie = trie;
    }

    static class TrieNode {
        Map<Character,TrieNode> children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        private synchronized void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children.get(c) == null) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.isEndOfWord = true;
        }

        public String replaceKeywords(String text, String replacement) {
            StringBuilder result = new StringBuilder();
            int i = 0;
            while (i < text.length()) {
                TrieNode node = root;
                int j = i;
                TrieNode endNode = null;
                int endIndex = -1;
                while (j < text.length() && node.children.get(text.charAt(j)) != null) {
                    node = node.children.get(text.charAt(j));
                    if (node.isEndOfWord) {
                        endNode = node;
                        endIndex = j;
                    }
                    j++;
                }
                if (endNode != null) {
                    result.append(replacement);
                    i = endIndex + 1;
                } else {
                    result.append(text.charAt(i));
                    i++;
                }
            }
            return result.toString();
        }
    }

}

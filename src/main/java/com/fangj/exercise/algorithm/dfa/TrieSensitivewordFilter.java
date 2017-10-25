package com.fangj.exercise.algorithm.dfa;

/**
 * @author fangjie
 * @date Created in 下午4:44 17/10/25.
 */
public class TrieSensitivewordFilter {

    TrieNode rootNode = new TrieNode();

    /**
     * 过滤敏感词
     */
    public String filter(String text, String replacement) {
        if (text.trim().length() == 0) {
            return text;
        }
        StringBuilder result = new StringBuilder();

        TrieNode tempNode = rootNode;
        int begin = 0; // 回滚数
        int position = 0; // 当前比较的位置

        while (position < text.length()) {
            char c = text.charAt(position);
            tempNode = tempNode.getSubNode(c);
            // 当前位置的匹配结束
            if (tempNode == null) {
                // 以begin开始的字符串不存在敏感词
                result.append(text.charAt(begin));
                // 跳到下一个字符开始测试
                position = begin + 1;
                begin = position;
                // 回到树初始节点
                tempNode = rootNode;
            } else if (tempNode.isKeyWordEnd()) {
                // 发现敏感词， 从begin到position的位置用replacement替换掉
                result.append(replacement);
                position = position + 1;
                begin = position;
                tempNode = rootNode;
            } else {
                ++position;
            }
        }
        result.append(text.substring(begin));
        return result.toString();
    }

    /**
     * 核心算法一：构建字典树
     * 根据输入的字符串，逐步构建字典树
     *
     * @param word
     */
    private void addWord(String word) {
        TrieNode tempNode = rootNode;
        for (int i = 0; i < word.length(); i++) {
            char charWord = word.charAt(i);
            TrieNode node = rootNode.getSubNode(charWord);
            if (node == null) {
                //说明tempNode第一次碰到该关键字结点
                node = new TrieNode();
                tempNode.addSubNode(charWord, node);
            }
            // tempNode指向下一个结点，开始下一次循环
            tempNode = node;
            // 到敏感词的最后一个字时，标记为红色（关键词结尾）
            if (i == word.length() - 1) {
                tempNode.setKeyWordEnd(true);
            }
        }
    }

    public static void main(String[] argv) {
        TrieSensitivewordFilter s = new TrieSensitivewordFilter();
        s.addWord("共产党");
        s.addWord("共产党");
        s.addWord("习近平");
        System.out.print(s.filter("共产党员为人民服务，亲爱的习近平主席。", "***"));
    }

}

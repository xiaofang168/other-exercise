package com.fangj.exercise.algorithm;

import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;

import java.util.Collection;

/**
 * @author fangjie
 * @date 2025/4/7 11:05
 */
public class AhoCorasickReplacer {

    private final Trie trie;

    public AhoCorasickReplacer(String keyWords) {
        // 构建Aho-Corasick自动机
        Trie.TrieBuilder builder = Trie.builder().ignoreOverlaps().onlyWholeWords();
        //trie.caseInsensitive();
        //trie.onlyWholeWords();
        for (String s : keyWords.split(";")) {
            builder.addKeyword(s);
        }
        this.trie = builder.build();
    }

    /**
     * 替换文本中所有匹配的关键字为空字符串
     */

    public String replaceKeywords(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        StringBuilder result = new StringBuilder();
        Collection<Emit> emits = trie.parseText(text); // 获取所有匹配结果
        int lastEnd = 0;
        for (Emit emit : emits) {
            int start = emit.getStart();
            int end = emit.getEnd();

            // 添加未匹配的前缀部分
            if (start > lastEnd) {
                result.append(text, lastEnd, start);
            }
            // 跳过匹配的关键字（即替换为空）
            lastEnd = end + 1; // 注意：end是闭区间，需+1移动到下一个字符
        }
        // 添加剩余未匹配的后缀部分
        if (lastEnd <= text.length() - 1) {
            result.append(text.substring(lastEnd));
        }
        return result.toString();
    }

}

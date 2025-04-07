package com.fangj.exercise.algorithm;

import org.junit.Test;

/**
 * @author fangjie
 * @date 2025/4/7 10:41
 */
public class ReplacerTest {

    @Test
    public void testTrieKeywordReplacer() {
        TrieKeywordReplacer replacer = new TrieKeywordReplacer("国家补贴 500 元");
        String s = replacer.replaceKeywords("HUAWEI Pura 70 Pro 国家补贴 500 元 羽砂黑 12GB+512GB 超高速风驰闪拍 华为鸿蒙智能手机");
        System.out.println(s);
    }

}

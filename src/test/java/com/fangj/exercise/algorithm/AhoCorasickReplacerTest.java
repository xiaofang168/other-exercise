package com.fangj.exercise.algorithm;

import org.junit.Test;

public class AhoCorasickReplacerTest {

    @Test
    public void testTrieKeywordReplacer() {
        AhoCorasickReplacer replacer = new AhoCorasickReplacer("国家补贴 500 元");
        String s = replacer.replaceKeywords("HUAWEI Pura 70 Pro 国家补贴 500 元 羽砂黑 12GB+512GB 超高速风驰闪拍 华为鸿蒙智能手机");
        System.out.println(s);
    }

}
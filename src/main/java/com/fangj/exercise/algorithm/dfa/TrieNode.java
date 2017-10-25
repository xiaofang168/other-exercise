package com.fangj.exercise.algorithm.dfa;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangjie
 * @date Created in 下午4:42 17/10/25.
 */
public class TrieNode {

    /**
     * 标识当前结点是否是一个“关键词”的最后一个结点
     * true 关键词的终结 false 继续
     */
    private boolean isEnd = false;

    /**
     * 用map来存储当前结点的所有子节点，非常的方便
     * key 下一个字符 value 对应的结点
     */
    private Map<Character, TrieNode> subNodes = new HashMap<>();

    /**
     * 向指定位置添加结点树
     *
     * @param key
     * @param node
     */
    public void addSubNode(Character key, TrieNode node) {
        subNodes.put(key, node);
    }

    /**
     * 根据key获得相应的子节点
     *
     * @param key
     * @return
     */
    public TrieNode getSubNode(Character key) {
        return subNodes.get(key);
    }

    /**
     * 判断是否是关键字的结尾
     *
     * @return
     */
    public boolean isKeyWordEnd() {
        return isEnd;
    }

    /**
     * 设置为关键字的结尾
     *
     * @param isEnd
     */
    public void setKeyWordEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

}

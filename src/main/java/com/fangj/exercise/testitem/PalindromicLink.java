package com.fangj.exercise.testitem;

/**
 * 判断是否是回文链表
 *
 * @author jefffang
 * @date Created in 4:11 下午 2022/7/28.
 */
public class PalindromicLink {

    class Solution {
        public boolean isPalindrome(TestNode head) {
            TestNode p1 = head, p2 = null;
            for (; p1 != null; p1 = p1.next) {
                p2 = new TestNode(p1.val, p2);
            }
            p1 = head;
            while (p2 != null) {
                if (p1.val != p2.val) {
                    return false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            return true;
        }
    }

    public static class TestNode {
        private int val;
        private TestNode next;

        public TestNode(int val, TestNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        TestNode node1 = new TestNode(1, null);
        TestNode node2 = new TestNode(2, node1);
        TestNode node3 = new TestNode(3, node2);
        TestNode node4 = new TestNode(4, node3);
        // 4 3 2 1
        TestNode node5 = new TestNode(3, node4);
        TestNode node6 = new TestNode(2, node5);
        TestNode node7 = new TestNode(1, node6);
        TestNode node8 = new TestNode(8, node7);

        PalindromicLink palindromicLink = new PalindromicLink();
        PalindromicLink.Solution solution = palindromicLink.new Solution();
        solution.isPalindrome(node7);

        String origin = loop(new StringBuilder(), node7);
        System.out.println("\n\n");
        TestNode newNode = reverse(node7);
        String dest = loop(new StringBuilder(), newNode);
        System.out.println(origin.equals(dest));
    }

    private static String loop(StringBuilder sb, TestNode node) {
        sb.append(node.val);
        if (node.next != null) {
            loop(sb, node.next);
        }
        return sb.toString();
    }

    private static TestNode reverse(TestNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        TestNode newNode = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return newNode;
    }

}

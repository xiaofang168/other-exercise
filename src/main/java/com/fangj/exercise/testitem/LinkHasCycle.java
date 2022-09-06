package com.fangj.exercise.testitem;

/**
 * @author jefffang
 * @date Created in 5:34 下午 2022/7/26.
 */
public class LinkHasCycle {

    static class TestNode {
        private int val;
        private TestNode next;

        public TestNode(int val, TestNode node) {
            this.val = val;
            this.next = node;
        }
    }

    public static void main(String[] args) {
        TestNode node1 = new TestNode(1, null);
        TestNode node2 = new TestNode(2, node1);
        TestNode node3 = new TestNode(3, node2);
        TestNode node4 = new TestNode(4, node3);
        TestNode node5 = new TestNode(5, node4);
        node1.next = node3;
        System.out.println(hasCycle(node5));
    }

    public static boolean hasCycle(TestNode node) {
        TestNode slow = node, fast = slow;
        while (fast != null && fast.next != null) {
            // 走一步
            slow = slow.next;
            // 走两部
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}

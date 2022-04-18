package com.fangj.exercise.testitem;

/**
 * @author jefffang
 * @date Created in 9:05 下午 2022/4/18.
 */
public class ReverseNode {

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val, ListNode next){
            this.val = val;
            this.next=next;
        }
    }

    public static ListNode recursion(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode new_head = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return new_head;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        loop(node1);
        System.out.println("\n");
        ListNode prev = recursion(node1);
        loop(prev);
    }

    public static void loop(ListNode head){
            if(head.next!=null){
                loop(head.next);
            }
        System.out.println(head.val);
    }

}

package com.leetcode;

public class ListNode {
    private int val;
    private ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.printf(" %d ", head.val);
            if (head.next != null) {
                System.out.printf("->");
            }
            head = head.next;
        }
    }

}

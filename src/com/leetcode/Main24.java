package com.leetcode;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Main24 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = new ListNode(-1);
        tmp.next = head;
        ListNode first = tmp.next;
        ListNode second = tmp.next.next;
        first.next = second.next;
        second.next = first;
        tmp = first;
        head = second;
        while (tmp.next != null && tmp.next.next != null) {
            ListNode left = tmp.next;
            ListNode right = tmp.next.next;
            left.next = right.next;
            right.next = left;
            tmp.next = right;
            tmp = right.next;
        }
        return head;
    }
    public static void printListNode(ListNode head) {
        while (head != null) {
            if (head.next == null) {
                System.out.printf("%d%n", head.val);
            }
            else {
                System.out.printf("%d -> ",head.val);
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Main24 m = new Main24();
        head = m.swapPairs(head);
        printListNode(head);
    }

}

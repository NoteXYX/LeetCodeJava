package com.leetcode;

/**
 * 234. 回文链表
 */
public class Main234 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    ListNode getFirstEnd(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    ListNode reverseListNode(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode firstEnd = getFirstEnd(head);
        ListNode secondStart = firstEnd.next;
        boolean res = true;
        secondStart = reverseListNode(secondStart);
        ListNode first = head;
        ListNode second = secondStart;
        while (second != null) {
            if (first.val != second.val) {
                res = false;
                break;
            }
            first = first.next;
            second = second.next;
        }
        secondStart = reverseListNode(secondStart);
        firstEnd.next = secondStart;
        return res;
    }
}

package com.leetcode;

/**
 * 链表的中间节点
 */
public class Main876 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode middleNode(ListNode head) {
        if (head==null || head.next==null)
            return head;
        ListNode fast = head;
        ListNode low = head;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            low = low.next;
        }
        return low;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        head.next = a;
        a.next = b;
        Main876 m = new Main876();
        System.out.println(m.middleNode(head).val);
    }
}

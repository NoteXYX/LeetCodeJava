package com.leetcode;

/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class Main19 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return null;
        }
        ListNode tail = head;
        for (int i = 0; i < n; i++) {
            tail = tail.next;
        }
        ListNode delPrv = head;
        if (tail == null) {
            return head.next;
        }
        while (tail.next != null) {
            tail = tail.next;
            delPrv = delPrv.next;
        }
        delPrv.next = delPrv.next.next;
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Main19 m = new Main19();
        head = m.removeNthFromEnd(head, 3);
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
}

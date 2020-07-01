package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Main21 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        priorityQueue.offer(l1);
        priorityQueue.offer(l2);
        ListNode head = new ListNode();
        ListNode tmp = head;
        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            tmp.next = node;
            tmp = tmp.next;
            if (node.next != null) {
                priorityQueue.offer(node.next);
            }
        }
        return head.next;
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
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        Main21 m = new Main21();
        printListNode(m.mergeTwoLists(l1,l2));
    }

}

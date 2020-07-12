package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 */
public class Main25 {
    public Map<String, ListNode> reverse(ListNode head, int k) {
        ListNode tmp = null;
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            ListNode next = head.next;
            head.next = tmp;
            tmp = head;
            head = next;
        }
        Map<String, ListNode> res = new HashMap<>();
        res.put("head", tmp);
        res.put("tail", tail);
        return res;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode hair = new ListNode(-1);
        hair.next = head;
        ListNode curNode = hair;
        ListNode pre = hair;
        while (head != null) {
            for (int i = 0; i < k; i++) {
                if (curNode != null) {
                    curNode = curNode.next;
                } else {
                    return hair.next;
                }
            }
            if (curNode == null)
                return hair.next;
            ListNode next = curNode.next;
            Map<String, ListNode> midRes = reverse(head, k);
            pre.next = midRes.get("head");
            midRes.get("tail").next = next;
            curNode = midRes.get("tail");
            pre = curNode;
            head = curNode.next;
        }
        return hair.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode h = head;
        head = (head.next = new ListNode(2));
        head = (head.next = new ListNode(3));
        head = (head.next = new ListNode(4));
        head = (head.next = new ListNode(5));
        Main25 m = new Main25();
        h = m.reverseKGroup(h, 2);
        ListNode.printListNode(h);
    }
}

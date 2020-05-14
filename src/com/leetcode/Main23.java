package com.leetcode;
import java.util.PriorityQueue;

/**
 * 23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。使用优先队列时间复杂度为O(klogn)k为链表个数，n为链表的最长长度
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Main23 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0)
            return null;
        if (lists.length == 1)
            return lists[0];
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode node: lists) {
            if (node != null)
                queue.add(node);
        }
        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tmp.next = node;
            tmp = tmp.next;
            if (node.next != null)
                queue.add(node.next);
        }
        return head.next;
    }
}

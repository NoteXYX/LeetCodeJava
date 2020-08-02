package com.leetcode;

/**
 * 148. 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class Main148 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode leftHead = sortList(head);
        ListNode rightHead = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (leftHead != null && rightHead != null) {
            if (leftHead.val <= rightHead.val) {
                h.next = leftHead;
                leftHead = leftHead.next;
            } else {
                h.next = rightHead;
                rightHead = rightHead.next;
            }
            h = h.next;
        }
        h.next = leftHead != null ? leftHead : rightHead;
        return res.next;
    }
}

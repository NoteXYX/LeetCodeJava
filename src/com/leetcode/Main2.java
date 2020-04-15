package com.leetcode;

/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Main2 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
        private void creat(ListNode head, int val) {
            while (head.next != null)
                head = head.next;
            head.next = new ListNode(val);
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode p = head;
        int addRes = 0;
        while (l1!=null && l2!=null) {
            addRes = l1.val + l2.val + carry;
            carry = addRes / 10;
            addRes %= 10;
            p.next = new ListNode(addRes);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            addRes = l1.val + carry;
            carry = addRes / 10;
            addRes %= 10;
            p.next = new ListNode(addRes);
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            addRes = l2.val + carry;
            carry = addRes / 10;
            addRes %= 10;
            p.next = new ListNode(addRes);
            p = p.next;
            l2 = l2.next;
        }
        if (carry == 1) {
            p.next = new ListNode(1);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.creat(l1, 4);
        l1.creat(l1, 3);
        ListNode l2 = new ListNode(5);
        l2.creat(l2,6);
        l2.creat(l2, 4);
        Main2 m = new Main2();
        ListNode res = m.addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.printf("%d -> " , res.val);
            res = res.next;
        }
    }
}

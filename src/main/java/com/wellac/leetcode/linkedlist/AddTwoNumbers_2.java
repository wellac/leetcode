package com.wellac.leetcode.linkedlist;

/**
 * 两数相加
 */
public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int temp = 0;

        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;

            int num = (v1 + v2 + temp) % 10;
            temp = (v1 + v2 + temp) / 10;

            ListNode tempNode = new ListNode(num);
            tail.next = tempNode;
            tail = tail.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (temp != 0) {
            ListNode tempNode = new ListNode(temp);
            tail.next = tempNode;
            tail = tail.next;
        }

        return dummy.next;

    }
}

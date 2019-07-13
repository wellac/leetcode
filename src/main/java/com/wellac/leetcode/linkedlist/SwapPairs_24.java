package com.wellac.leetcode.linkedlist;

/**
 * 24. 两两交换链表中的节点
 */
public class SwapPairs_24 {

    //递归解法
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }

    //迭代解法
    public ListNode swapPairs_1(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            ListNode temp = curr.next;
            curr.next = curr.next.next;
            temp.next = curr.next.next;
            curr.next.next = temp;
            curr = curr.next.next;
        }
        return dummy.next;
    }
}

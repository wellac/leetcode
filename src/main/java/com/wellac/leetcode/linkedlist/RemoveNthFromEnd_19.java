package com.wellac.leetcode.linkedlist;

/**
 * 19. 删除链表的倒数第N个节点
 */
public class RemoveNthFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode end = dummy;
        ListNode prev = dummy;
        for (int i = 0; i < n; i++) {
            end = end.next;
        }
        while (end.next != null) {
            prev = prev.next;
            end = end.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }
}

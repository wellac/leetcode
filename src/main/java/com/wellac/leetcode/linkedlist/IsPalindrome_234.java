package com.wellac.leetcode.linkedlist;

/**
 * 234. 回文链表
 */
public class IsPalindrome_234 {

    //    先用slow-fast指针法找到链表中点
    //    同时将链表前半部分反转
    //    最后判断两个链表是否相同
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head.next;

        ListNode slow_prev = null;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;

            ListNode temp = slow.next;
            slow.next = slow_prev;
            slow_prev = slow;
            slow = temp;
        }


        ListNode mid = null;

        if (fast.next == null) {
            mid = slow.next;
        } else {
            mid = slow.next.next;
        }

        slow.next = slow_prev;

        while (mid != null) {
            if (slow.val != mid.val) return false;
            slow = slow.next;
            mid = mid.next;
        }

        return true;
    }
}

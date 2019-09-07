package com.wellac.leetcode.linkedlist;

/**
 * 2.两数相加
 */
public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;//记录进位
        while (l1 != null || l2 != null || carry != 0) {
            //带进位求和，并计算进位
            int sum = carry + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            carry = sum / 10;

            //尾插法插入新节点
            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            //向后移动l1,l2
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return dummy.next;
    }
}

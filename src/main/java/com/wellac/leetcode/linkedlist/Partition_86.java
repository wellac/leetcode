package com.wellac.leetcode.linkedlist;

/**
 * 分隔链表
 */
public class Partition_86 {

    public ListNode partition(ListNode head, int x) {

        ListNode less_head = new ListNode(0);
        ListNode less_tail = less_head;

        ListNode more_head = new ListNode(0);
        ListNode more_tail = more_head;

        while(head!=null){
            if(head.val<x){
                less_tail.next = head;
                less_tail = head;
            }else{
                more_tail.next = head;
                more_tail = head;
            }

            head = head.next;
        }

        less_tail.next = more_head.next;
        more_tail.next=null;

        return less_head.next;
    }
}

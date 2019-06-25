package com.wellac.leetcode.linkedlist;

import org.junit.Test;

/**
 * 环形链表 II
 */
public class detectCycle_142 {

    @Test
    public void test(){
        ListNode listNode = buildData();
        ListNode listNode1 = detectCycle(listNode);
        System.out.println(listNode1.val);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast= head;
        ListNode slow = head;

        ListNode meet = null;
        while(fast!=null && fast.next !=null){
            fast =fast.next.next;
            slow = slow.next;
            if(fast == slow){
                meet = fast;
                break;
            }
        }

        if(meet == null){
            return null;
        }

        ListNode slow1 = head;
        ListNode slow2 = meet;

        while(slow1!=slow2){
            slow1 = slow1.next;
            slow2 = slow2.next;
        }

        return slow2;

    }

    private ListNode buildData() {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;
        return node1;
    }
}

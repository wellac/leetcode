package com.wellac.leetcode.linkedlist;

/**
 * 判断链表是否有环
 */
public class HasCycle_141 {

    public boolean hasCycle(ListNode head) {
        //做非空校验
        if(head==null ||head.next==null){
            return false;
        }

        //定义快慢指针
        ListNode fast = head.next;
        ListNode slow = head;

        //迭代比较
        while(fast != slow){
            if(fast.next==null ||fast.next.next==null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return true;
    }
}

package com.wellac.leetcode.linkedlist;

import org.junit.Test;

public class  ReverseBetween_92 {

    @Test
    public void test() {
        ListNode head = buildData();
        printList(head);
        System.out.println("-------------------------");
        head = reverseBetween(head,2,4);
        printList(head);
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {

        //记录反转部分反转后的头节点和尾节点
        ListNode new_head = null;
        ListNode new_tail = null;

        //记录反转部分的前驱节点和后继节点
        ListNode new_head_prev = null;
        ListNode new_tail_next = null;

        //记录迭代过程中的当前节点和前驱节点
        ListNode curr = head;
        ListNode prev = null;

        //记录迭代过程中当前节点是第几个节点
        int curr_index = 1;

        //若当前节点不为空则迭代并反转指定区域的节点
        while(curr!=null){
            //若当前节点是指定反转区域的第一个节点则：
            // 1.当前节点的前驱是反转区域的前驱(new_head_prev)
            // 2.当前节点是反转区域反转后的尾节点(new_tail)
            if(curr_index == m){
                new_head_prev = prev;
                new_tail = curr;
            }

            //若当前节点是指定反转区域的最后一个节点则：
            // 1.当前节点的后继是反转区域的后继(new_tail_next)
            // 2.当前节点是反转区域反转后的头节点(new_head)
            if(curr_index == n){
                new_tail_next = curr.next;
                new_head = curr;
            }

            //记录当前节点的后继节点，防止在反转过程中断链
            ListNode temp = curr.next;

            //若当前节点处于反转区域中，则进行反转
            if(curr_index>=m && curr_index<=n){
                curr.next = prev;
            }

            //指针后移
            prev = curr;
            curr = temp;
            curr_index++;
        }

        //让反转区域反转后的尾节点指向其后继
        new_tail.next = new_tail_next;


        if(new_head_prev!=null){
            //让反转区域的前驱指向反转区域反转后的头节点
            new_head_prev.next = new_head;
            return head;
        }else{
            //当new_head_prev为null时，说明是从第一个节点开始反转的，直接返回反转区域反转后的头节点即可
            return new_head;
        }

    }

    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private void printList(ListNode head){
        while (head != null) {
            System.out.print(head.val+"\t");
            head = head.next;
        }
        System.out.println();
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
        return node1;
    }

}

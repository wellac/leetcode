package com.wellac.leetcode;

import org.junit.Test;

/**
 * 反转一个单链表。
 */
public class ReverseList_206 {

    @Test
    public void test() {
        ListNode head = buildData();
        printList(head);
        System.out.println("-------------------------");
//        head = reverseList_1(head);
        head = reverseList_2(head);
        printList(head);
    }
    public ListNode reverseList_1(ListNode head) {

        //1.若空，则直接返回。
        if (head == null) {
            return null;
        }

        //2.截取链表第一个节点做反转后的链表new_head
        ListNode new_head = head;
        head = head.next;
        new_head.next = null;//这里记得置空，因为第一个节点是反转后的尾节点

        //3.遍历链表，将链表节点以头插法的方式插入new_head
        while (head != null) {
            ListNode temp = head.next;//记住链表下一个节点，防止断链
            head.next = new_head;
            new_head = head;
            head = temp;
        }

        //4.返回逆转后的链表
        return new_head;
    }

    //递归的做法
    public ListNode reverseList_2(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }

        //将链表第一个节点之后的节点反转
        ListNode new_head = reverseList_2(head.next);

        //此时head的next域中保存的是反转后的尾节点
        //让反转后链表的尾节点指向head,并将head的next域置为null即可完成反转
        head.next.next = head;
        head.next = null;

        return new_head;
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
            System.out.println(head.val);
            head = head.next;
        }
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



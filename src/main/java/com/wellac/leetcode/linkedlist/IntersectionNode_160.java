package com.wellac.leetcode.linkedlist;

/**
 * 相交链表
 */
public class IntersectionNode_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //获取A,B链表的长度并对齐
        int lengthA = getListLength(headA);
        int lengthB = getListLength(headB);
        if(lengthA>lengthB){
            for(int i = 1;i<=(lengthA-lengthB);i++){
                headA= headB.next;
            }
        }else if(lengthA<lengthB){
            for(int i = 1;i<=(lengthB-lengthA);i++){
                headB= headB.next;
            }
        }

        //比价获得交点
        while(headA!=null){
            if(headA==headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        //没有交点则返回null
        return null;


    }

    private int getListLength(ListNode head){
        int length = 0;
        while(head!=null){
            head = head.next;
            length++;
        }
        return length;
    }
}

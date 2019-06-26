package com.wellac.leetcode.linkedlist;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并K个排序链表
 */
public class MergeKLists_23 {

    //方法1：采用优先队列
    public ListNode mergeKLists_1(ListNode[] lists) {
        /**
         * 优先队列其实内部实现就是一个堆的数据结构，
         * java默认的是一个小跟堆，每次取出最小的元素，
         * 因为堆的性质他可以做到O(logn)级别的插入和删除操作。
         */
        PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for(ListNode list :lists){
            if(list!=null){
                q.add(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail  = dummy;
        while(!q.isEmpty()){
            tail.next=q.poll();
            tail = tail.next;
            if(tail.next!=null){
                q.add(tail.next);
            }
        }
        return dummy.next;
    }

    //方法2：采用分治的思想
    public ListNode mergeKLists_2(ListNode[] lists,int start,int end){
        if(lists==null ||end<start){
            return null;
        }
        if(start==end){
            return lists[start];
        }
        if(start+1 == end){
            return mergeTwoLists(lists[start],lists[end]);
        }

        int mid = (start+end)/2;

        return mergeTwoLists(mergeKLists_2(lists,start,mid),mergeKLists_2(lists,mid+1,end));

    }

    private ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(l1!=null &&l2!=null){
            if(l1.val<=l2.val){
                tail.next = l1;
                l1=l1.next;
            }else{
                tail.next = l2;
                l2=l2.next;
            }
            tail =tail.next;
        }
        if(l1!=null){
            tail.next = l1;
        }

        if(l2!=null){
            tail.next = l2;
        }
        return dummy.next;
    }
}

package com.wellac.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * LinkedLis可以作为队列和栈来使用
 */
public class LinkedListDemo {

    @Test
    //LinkedList作为队列使用
    public void asQueue(){
        LinkedList<Integer> q = new LinkedList<>(Arrays.asList(1,2,3,4));
        System.out.println(q);
        //出队操作(检索并删除此队列的头部，如果此队列为空，则返回null。)
        System.out.println("出队："+q.poll());
        System.out.println("出队："+q.poll());
        System.out.println(q);
        //入队操作（则将指定的元素插入此队列）
        System.out.println("入队："+q.offer(5));
        System.out.println("入队："+q.offer(6));
        System.out.println(q);
        //窥视操作（检索但不移除此队列的头部，如果此队列为空，则返回null。）
        System.out.println(q.peek());
    }
    @Test
    //LinkedList作为栈使用
    public void asStack(){
        LinkedList<Integer> s = new LinkedList<>(Arrays.asList(1,2,3,4));
        System.out.println(s);
        //出队操作(检索并删除此队列的头部，如果此队列为空，则返回null。)
        System.out.println("出栈："+s.pop());
        System.out.println("出栈："+s.pop());
        System.out.println(s);
        //入队操作（则将指定的元素插入此队列）
        System.out.println("入栈");
        s.push(5);
        s.push(6);
        System.out.println(s);
        //窥视操作（检索但不移除此队列的头部，如果此队列为空，则返回null。）
        System.out.println(s.peek());
    }
}

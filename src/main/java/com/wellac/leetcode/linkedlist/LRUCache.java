package com.wellac.leetcode.linkedlist;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 146. LRU缓存机制
 */
public class LRUCache {
    private int capacity;
    private int size;
    private DoubleList list;
    private Map<Integer, Node> map;


    public LRUCache(int capacity) {
        this.list = new DoubleList();
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;

        list.remove(node);
        list.addFirst(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        //当Key存在时，直接修改对应的value
        if (node != null) {
            node.val = value;
            list.remove(node);
            list.addFirst(node);
            return;
        }

        //当Key不存在时，插入新的node
        //淘汰过期缓存
        if (size == capacity){
            Node temp = list.removeLast();
            map.remove(temp.key);
        }else {
            size++;
        }

        node = new Node(key, value);
        map.put(key, node);
        list.addFirst(node);
    }


}

class Node {
    public int key, val;
    public Node next, prev;

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

class DoubleList {
    private Node head,tail;
    private int size;

    DoubleList() {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.size = 0;
    }

    public void addFirst(Node node) {
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next.prev = node;
        this.head.next = node;
        this.size++;
    }

    public Node remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev=null;
        node.next=null;
        this.size--;
        return node;
    }

    public Node removeLast() {
        return remove(tail.prev);
    }
}


package com.wellac.leetcode.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest {

    @Test
    public void test(){
        LRUCache c = new LRUCache(2);
        c.put(2,1);
        c.put(1,2);
        c.put(3,3);
        c.put(4,4);
        System.out.println();

    }
}
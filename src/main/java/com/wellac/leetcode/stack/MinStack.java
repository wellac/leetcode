package com.wellac.leetcode.stack;

import java.util.Stack;

/**
 * 155. 最小栈
 */
public class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> helper;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (helper.isEmpty() || x <= helper.peek()) {
            helper.push(x);
        }
    }

    public void pop() {
        Integer pop = data.pop();
        if(pop.equals(helper.peek())){
            helper.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return helper.peek();
    }
}

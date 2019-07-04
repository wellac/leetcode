package com.wellac.leetcode.string;

import org.junit.Test;

import java.util.Stack;

/**
 * 20. 有效的括号
 */
public class IsValid_20 {
    @Test
    public void test() {
        System.out.println(isValid("]"));

    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            if (ch == ')' || ch == ']' || ch == '}') {
                if(stack.isEmpty()) return false;
                char temp = stack.pop();
                if (temp == '(' && ch != ')') return false;
                if (temp == '[' && ch != ']') return false;
                if (temp == '{' && ch != '}') return false;
            }
        }
        return stack.isEmpty();
    }
}

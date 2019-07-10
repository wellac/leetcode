package com.wellac.leetcode.math;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 */
public class RomanToInt_13 {
    private Map<Character, Integer> map = new HashMap<Character, Integer>() {
        {
            put('M', 1000);
            put('D', 500);
            put('C', 100);
            put('L', 50);
            put('X', 10);
            put('V', 5);
            put('I', 1);
        }
    };

    @Test
    public void test() {
        System.out.println(romanToInt("IV"));
    }

    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = map.get(s.charAt(i));
            if (i < s.length() - 1) {
                int next = map.get(s.charAt(i + 1));
                if (next > curr) {
                    res = res + (next - curr);
                    i++;
                    continue;
                }
            }
            res = res + curr;
        }
        return res;
    }
}

package com.wellac.leetcode.string;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 8. 字符串转换整数 (atoi)
 */
public class MyAtoi_8 {
    HashSet<Character> numberSet = new HashSet<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
    HashSet<Character> set = new HashSet<>(Arrays.asList('+', '-', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
    HashMap<Character, Integer> map = new HashMap<>();

    {
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
    }

    @Test
    public void test() {
        System.out.println(myAtoi(" "));
    }

    public int myAtoi(String str) {
        System.out.println(str);
        int res = 0;

        if (str.length() == 0) return res;

        int start = 0;
        for (; start < str.length(); start++) {
            if (str.charAt(start) != ' ') break;
        }

        if (str.length() - 1 < start) return res;

        str = str.substring(start);

        System.out.println(str);


        if (!numberSet.contains(str.charAt(0))) {
            if (str.charAt(0) == '+') {
                res = 1;
            } else if (str.charAt(0) == '-') {
                res = -1;
            } else {
                return 0;
            }
            str = str.substring(1);
        } else {
            res = 1;
        }

        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!numberSet.contains(str.charAt(i))) break;
            if (Integer.MAX_VALUE / 10 < num || (Integer.MAX_VALUE / 10 == num && map.get(str.charAt(i)) > 7)) {
                if (res == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    if (Integer.MAX_VALUE / 10 < num)
                        return Integer.MIN_VALUE;
                    else if (map.get(str.charAt(i)) > 8)
                        return Integer.MIN_VALUE;
                }

            }

            num = num * 10 + map.get(str.charAt(i));
        }


        return res * num;
    }
}

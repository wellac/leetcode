package com.wellac.leetcode.math;

import org.junit.Test;

/**
 * 12. 整数转罗马数字
 */
public class IntToRoman {
    @Test
    public void test() {
        for (int i = 0; i < 3999; i++) {
            System.out.println(intToRoman(i));
        }
    }

    public String intToRoman(int num) {
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] chs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            while (num >= value[i]) {
                res.append(chs[i]);
                num = num - value[i];
            }
        }
        return res.toString();
    }
}

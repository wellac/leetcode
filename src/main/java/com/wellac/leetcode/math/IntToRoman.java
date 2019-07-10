package com.wellac.leetcode.math;

import org.junit.Test;

/**
 * 12. 整数转罗马数字
 */
public class IntToRoman {
    @Test
    public void test() {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
    }

    public String intToRoman(int num) {
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] ch = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < value.length && num != 0; i++) {
            int temp = num / value[i];
            if (temp > 0) {
                for (int j = temp; j > 0; j--) {
                    res.append(ch[i]);
                }
                num -= value[i] * temp;
            }
        }
        return res.toString();
    }
}

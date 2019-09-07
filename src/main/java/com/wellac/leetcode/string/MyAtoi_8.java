package com.wellac.leetcode.string;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 8. 字符串转换整数 (atoi)
 */
public class MyAtoi_8 {
    @Test
    public void test() {
        System.out.println(myAtoi("-2147483649"));
    }

    public int myAtoi(String str) {
        //处理特殊情况
        if (str == null) return 0;
        str = str.trim();
        if (str.equals("")) return 0;

        //获取符号位
        int flag = 1;
        int curr = 0;
        char firstChar = str.charAt(curr);
        if (firstChar == '-') {
            flag = -1;
            curr++;
        } else if (firstChar == '+') {
            curr++;
        } else if (!Character.isDigit(firstChar)) {
            return 0;
        }

        //开始转换
        int res = 0;
        while (curr < str.length()) {
            if (!Character.isDigit(str.charAt(curr))) {
                return res;
            }
            int num = flag * (str.charAt(curr++) - '0');
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && num < Integer.MIN_VALUE % 10)) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + num;
        }
        return res;
    }
}

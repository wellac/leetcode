package com.wellac.leetcode.string;

import org.junit.Test;

/**
 * 43. 字符串相乘
 */
public class Multiply_43 {
    @Test
    public void test() {
        System.out.println(multiply("99999", "99999"));
        System.out.println(999 * 999);
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();

        StringBuilder res = new StringBuilder(len1 + len2);

        /**
         *  curr:当前计算的位置（1：个位，2：百位）
         *  carry：当前计算的进位
         */
        for (int curr = 1, carry = 0; curr < len1 + len2 || carry > 0; curr++) {
            System.out.println(curr);
            // fromNum1:num1计算的位置（1：个位，2：百位;1 <= fromNum1 <= len1）
            // fromNum2:num2计算的位置（1：个位，2：百位;1 <= fromNum2 <= len2）
            // 满足关系:fromNum1 + fromNum2 - 1 = curr => fromNum2 = curr - fromNum1 + 1
            // 位置和下标的关系:index = len - fromNum
            for (int fromNum1 = Math.min(curr, len1),
                 fromNum2 = curr - fromNum1 + 1;
                 fromNum1 >= 1 && fromNum2 <= len2;
                 fromNum1--, fromNum2++) {
                carry += (num1.charAt(len1 - fromNum1) - '0') * (num2.charAt(len2 - fromNum2) - '0');
            }

            res.append(carry % 10);
            carry /= 10;
        }
        return res.reverse().toString();
    }
}

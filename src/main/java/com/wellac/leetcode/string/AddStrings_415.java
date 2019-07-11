package com.wellac.leetcode.string;

import org.junit.Test;

/**
 * 415. 字符串相加
 */
public class AddStrings_415 {
    @Test
    public void test(){
        System.out.println(addStrings("9", "99"));
    }

    public String addStrings(String num1, String num2) {

        int carry = 0;

        int curr1 = num1.length()-1;
        int curr2 = num2.length()-1;

        StringBuilder sum = new StringBuilder();

        while (curr1 >= 0 && curr2 >= 0) {
            int temp = carry + num1.charAt(curr1--) + num2.charAt(curr2--) - 2 * '0';
            carry = temp / 10;
            sum.append(temp % 10);
        }
        while (curr1 >= 0 ||curr2 >= 0) {
            int temp;
            if (curr1 >= 0){
                temp = carry + num1.charAt(curr1--) - '0';
            }else {
                temp = carry + num2.charAt(curr2--) - '0';
            }
            carry = temp / 10;
            sum.append(temp % 10);
        }
        if (carry>0){
            sum.append(carry);
        }

        return sum.reverse().toString();
    }
}

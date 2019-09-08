package com.wellac.leetcode.string;

import org.junit.Test;

/**
 * 43. 字符串相乘
 */
public class Multiply_43 {
    @Test
    public void test() {
        System.out.println(multiply("12", "13"));
        System.out.println(999 * 999);
    }

    public String multiply(String num1, String num2) {
        int[] mul = new int[num1.length() + num2.length()];

        for(int i = 0; i <num1.length(); i++ ){
            for(int j = 0; j < num2.length(); j++){
                int temp = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                mul[i+j] += temp/10;
                mul[i+j+1] += temp%10;
            }
        }
        for(int i = mul.length-1;i>0;i--){
            int temp =mul[i];
            mul[i] = temp%10;
            mul[i-1] += temp/10;
        }

        StringBuilder res = new StringBuilder();
        for(int i = 0 ;i < mul.length; i++){
            if(mul[i]==0 &&res.length()==0){
                continue;
            }
            res.append(mul[i]);
        }
        return res.toString();
    }
}

package com.wellac.leetcode.string;

import org.junit.Test;

import java.util.Stack;

/**
 * 394. 字符串解码
 */
public class DecodeString_394 {
    @Test
    public void test() {
        System.out.println(decodeString("kkk3[a2[c]]"));
    }

    /**
     * 维护两个stack
     * 1,count, 存放重复次数
     * 2,str, 存放字符串
     *
     * 迭代字符串s
     * 1,若为字母，添加到res
     * 2,若遇到数字，则获取对应数字，入栈countstack
     * 3,若遇到’[‘, 将res(已解码字符串)入栈，置res为空(用来获取’[]’内的字符串)
     * 4,若遇到’]’, 出栈resStack，出栈countstack,获取重复次数k，重复res k次，添加到出栈字符串上
     */
    public String decodeString(String s) {

        Stack<Integer> count = new Stack<>();//存放重复次数
        Stack<String> str = new Stack<>();//存放字符串

        String res = "";
        int index = 0;

        while (index < s.length()) {
            if (Character.isLetter(s.charAt(index))) {
                res += s.charAt(index);
                index++;
            } else if (Character.isDigit(s.charAt(index))) {
                int num = 0;
                while (Character.isDigit(s.charAt(index))) {
                    num = num * 10 + (s.charAt(index) - '0');
                    index++;
                }
                count.push(num);
            } else if (s.charAt(index) == '[') {
                str.push(res);
                res="";
                index++;
            } else {
                Integer num = count.pop();
                StringBuilder temp = new StringBuilder(str.pop());
                for (int j = 0; j < num; j++) {
                    temp.append(res);
                }
                res = temp.toString();
                index++;
            }
        }
        return res;
    }
}

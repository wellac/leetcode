package com.wellac.leetcode.string;

/**
 * 344. 反转字符串
 */
public class ReverseString_344 {
    public void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
}

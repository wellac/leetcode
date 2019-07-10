package com.wellac.leetcode.string;

import org.junit.Test;

/**
 * 6. Z 字形变换
 */
public class Convert_6 {
    @Test
    public void test(){
        System.out.println(convert("LEETCODEISHIRING",3));
    }

    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        int len = s.length();
        for (int i = 0; i < len; ) {
            for (int j = 0; j < numRows && i < len; j++, i++) {
                sb[j].append(s.charAt(i));
            }
            for (int j = numRows - 2; j > 0 && i < len; j--, i++) {
                sb[j].append(s.charAt(i));
            }
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder e : sb) {
            res.append(e);
        }

        return res.toString();
    }
}

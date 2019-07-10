package com.wellac.leetcode.dp;

import org.junit.Test;

/**
 * 5. 最长回文子串
 */
public class LongestPalindrome_5 {

    @Test
    public void test() {
        System.out.println(longestPalindrome_2("babc"));
    }

    //暴力解法，时间复杂度o（n^2)
    public String longestPalindrome_1(String s) {
        if (s.equals("")) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j) && end - start < j - i) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    //动态规划解法
    public String longestPalindrome_2(String s) {
        if (s.equals("")) return "";

        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        int start = 0;//最长回文子串的起始下标
        int max = 1;//最长回文子串的长度
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                max = 2;
                start = i;
            }
        }
        for (int w = 3; w <= len; w++) {
            for (int i = 0; i <= len - w; i++) {
                if (s.charAt(i) == s.charAt(i + w - 1) && dp[i + 1][i + w - 2]) {
                    dp[i][i + w - 1] = true;
                    max = w;
                    start = i;
                }
            }
        }
        return s.substring(start, start + max);
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}

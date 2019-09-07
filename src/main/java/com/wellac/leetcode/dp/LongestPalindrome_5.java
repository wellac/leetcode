package com.wellac.leetcode.dp;

import org.junit.Test;

/**
 * 5. 最长回文子串
 */
public class LongestPalindrome_5 {

    @Test
    public void test() {
        System.out.println(longestPalindrome("babc"));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        int max_len = 0;
        int start = 0;
        boolean[][] dp = new boolean[len][len];

        for (int w = 1; w <= len; w++) {
            for (int i = 0, j = i + w - 1; j < len; i++, j++) {
                dp[i][j] = (w == 1)
                        || (w == 2 && s.charAt(i) == s.charAt(j))
                        || (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j));

                if (dp[i][j]) {
                    max_len = w;
                    start = i;
                }
            }
        }
        return s.substring(start, start + max_len);
    }
}

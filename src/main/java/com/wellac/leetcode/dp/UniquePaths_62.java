package com.wellac.leetcode.dp;

import org.junit.Test;

/**
 * 62. 不同路径
 */
public class UniquePaths_62 {

    @Test
    public void test() {
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(3, 7));
    }

    //动态规划解法
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i * j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    //暴力递归（超过时间限制）
    public int uniquePaths_1(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePaths_1(m, n - 1) + uniquePaths_1(m - 1, n);
    }
}

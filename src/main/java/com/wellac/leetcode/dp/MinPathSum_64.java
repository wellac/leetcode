package com.wellac.leetcode.dp;

/**
 * 64. 最小路径和
 */
public class MinPathSum_64 {
    //动态规划
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i > 0 && j > 0) {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                } else if (i == 0 && j > 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0 && i > 0) {
                    grid[i][j] += grid[i - 1][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    //暴力递归
    public int minPathSum_1(int[][] grid, int n, int m) {
        int sum = 0;
        if (n == 0) {
            for (int i = 0; i <= m; i++) {
                sum += grid[0][i];
            }
            return sum;
        }
        if (m == 0) {
            for (int i = 0; i <= n; i++) {
                sum += grid[i][0];
            }
            return sum;
        }

        return Math.min(minPathSum_1(grid, n, m - 1), minPathSum_1(grid, n - 1, m)) + grid[n][m];
    }
}

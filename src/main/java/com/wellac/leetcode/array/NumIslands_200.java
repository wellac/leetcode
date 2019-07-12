package com.wellac.leetcode.array;

import org.junit.Test;

/**
 * 200. 岛屿数量
 */
public class NumIslands_200 {

    //确定搜索的四个方向
    private int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    //定义整个搜索区域的范围
    private int x, y;

    private boolean[][] used;

    @Test
    public void test() {
        char [][] arr = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        numIslands(arr);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        this.x = grid.length;
        this.y = grid[0].length;
        used = new boolean[this.x][this.y];
        int res = 0;
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                if (grid[i][j] == '1' && !used[i][j]) {
                    res++;
                    System.out.println("发现陆地");
                    dfs(grid, i, j);
                    System.out.println("发现一座岛屿");
                }
            }
        }
        return res;
    }

    //从grid[x][y]开始标记所有与grid[x][y]相连的陆地
    private void dfs(char[][] grid, int x, int y) {
        used[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newx = x + d[i][0];
            int newy = y + d[i][1];
            if (inArea(newx,newy) && !used[newx][newy] && grid[newx][newy] == '1' ){
                System.out.println("发现陆地");
                dfs(grid,newx,newy);
            }
        }
    }

    //判断坐标是否在整个搜索区域的范围内
    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.x && y >= 0 && y < this.y;
    }
}

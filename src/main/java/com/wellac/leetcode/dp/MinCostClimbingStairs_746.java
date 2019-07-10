package com.wellac.leetcode.dp;

import org.junit.Test;

import javax.xml.ws.RequestWrapper;

/**
 * 746. 使用最小花费爬楼梯
 */
public class MinCostClimbingStairs_746 {
    @Test
    public void test() {
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    //动态规划
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if (len == 0) return 0;
        int dp0 = cost[0];
        if (len == 1) return dp0;
        int dp1 =  cost[1];
        if (len == 2) return dp1;
        for (int i = 2; i <= len; i++) {
            int temp = (i == len ? 0 : cost[i]) + Math.min(dp0, dp1);
            dp0 = dp1;
            dp1 = temp;
        }
        return dp1;
    }
}

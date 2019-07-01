package com.wellac.leetcode.dp;

import org.junit.Test;

/**
 * 121. 买卖股票的最佳时机
 */
public class MaxProfit_121 {

    @Test
    public void test() {
        int[] prices = new int[]{1, 2};
        System.out.println(maxProfit_2(prices));
    }

    //方法1：暴力遍历(时间复杂度：o(n^2))
    //找到数组中prices[i]-prices[j](i<j)的最大值
    public int maxProfit_1(int[] prices) {
        int max = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = max > prices[j] - prices[i] ? max : prices[j] - prices[i];
            }
        }
        return max;
    }

    //方法2：一次遍历(时间复杂度：o(n))
    //找到数组中最小值和最小值后的最大值
    public int maxProfit_2(int[] prices) {
        int minPrices = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minPrices > prices[i]) {
                minPrices = prices[i];
            }else if(maxProfit<prices[i]-minPrices){
                maxProfit = prices[i]-minPrices;
            }
        }
        return maxProfit;
    }
}

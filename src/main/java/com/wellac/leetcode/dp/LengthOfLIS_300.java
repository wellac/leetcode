package com.wellac.leetcode.dp;

/**
 * 300. 最长上升子序列
 */
public class LengthOfLIS_300 {
    //动态规划
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }

        int res = Integer.MIN_VALUE;
        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res;


        //return lengthOfLIS(nums, nums.length-1, Integer.MAX_VALUE);

    }

    //递归法
    public int lengthOfLIS(int[] nums, int end, int max) {
        if (end == 0) {
            if (nums[end] >= max) return 0;
            else return 1;
        }

        if (nums[end] >= max) {
            return lengthOfLIS(nums, end - 1, max);
        } else {
            return Math.max(lengthOfLIS(nums, end - 1, max), 1 + lengthOfLIS(nums, end - 1, nums[end]));
        }

    }
}

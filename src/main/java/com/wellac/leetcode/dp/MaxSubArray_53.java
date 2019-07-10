package com.wellac.leetcode.dp;

/**
 * 53. 最大子序和
 */
public class MaxSubArray_53 {
    //动态规划(空间复杂o(1)版)
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int dp = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (dp>0) {
                dp = dp + nums[i];
            }else{
                dp = nums[i];
            }
            max = Math.max(dp,max);
        }

        return max;
    }

    //动态规划
    public int maxSubArray_1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1]>0) {
                dp[i] = dp[i-1] + nums[i];
            }else{
                dp[i] = nums[i];
            }
            max = Math.max(dp[i],max);
        }

        return max;
    }

    //递推
    public int maxSubArray_2(int[] nums) {
        int max = Integer.MIN_VALUE;

        int len = nums.length;
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
            max = Math.max(max, dp[i][i]);
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = dp[i][j - 1] + nums[j];
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

    //暴力遍历：超过时间限制
    public int maxSubArray_3(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = getSum(nums, i, j);
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    private int getSum(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        return sum;
    }

}

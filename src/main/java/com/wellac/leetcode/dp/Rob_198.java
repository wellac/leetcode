package com.wellac.leetcode.dp;

/**
 * 198. 打家劫舍
 */
public class Rob_198 {
    public int rob(int[] nums) {
        return solve_2(nums);
    }

    private int solve(int[] nums, int end) {
        if (end < 0) return 0;

        return Math.max(solve(nums, end - 1), nums[end] + solve(nums, end - 2));
    }


    private int solve_2(int[] nums) {
        int pre2 = 0;
        int pre1 = 0;

        for (int i = 0; i < nums.length; i++) {
            int curr = Math.max(nums[i] + pre2, pre1);
            pre2 = pre1;
            pre1 = curr;
        }

        return pre1;
    }
}

package com.wellac.leetcode.dp;

/**
 *
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
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);

        int res1 = nums[0];
        int res2 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            int res3 = Math.max(nums[i] + res1, res2);
            res1 = res2;
            res2 = res3;
        }

        return res2;
    }
}

package com.wellac.leetcode.dp;

/**
 * 213. 打家劫舍 II
 */
public class Rob_213 {
    public int rob(int[] nums) {
        if (nums == null) return 0;
        int len = nums.length;
        if (len == 1) return nums[0];
        //将问题分解成偷第一家和不偷第一家
        return Math.max(rob(nums, 0, len - 2), rob(nums, 1, len - 1));
    }


    private int rob(int[] nums, int start, int end) {
        int pre2 = 0;
        int pre1 = 0;

        for (int i = start; i <= end; i++) {
            int curr = Math.max(nums[i] + pre2, pre1);
            pre2 = pre1;
            pre1 = curr;
        }

        return pre1;
    }
}

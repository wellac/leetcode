package com.wellac.leetcode.math;

/**
 * 136. 只出现一次的数字
 */
public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}

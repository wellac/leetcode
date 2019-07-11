package com.wellac.leetcode.math;

/**
 * 137. 只出现一次的数字 II
 */
public class SingleNumber_117 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((mask & nums[j]) != 0) {
                    count++;
                }
            }
            if (count % 3 == 1) {
                res = res | mask;
            }
        }
        return res;
    }
}

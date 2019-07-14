package com.wellac.leetcode.array;

import java.util.Arrays;

/**
 * 169. 求众数
 */
public class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

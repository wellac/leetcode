package com.wellac.leetcode.array;

import java.util.Arrays;

/**
 * 169. 求众数
 */
public class MajorityElement_169 {

    //Boyer-Moore 投票算法
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count==0){
                major = nums[i];
                count++;
                continue;
            }
            if (major == nums[i]) {
                count++;
            }else {
                count--;
            }
        }
        return major;
    }
}

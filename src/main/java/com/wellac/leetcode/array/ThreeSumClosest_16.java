package com.wellac.leetcode.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 */
public class ThreeSumClosest_16 {

    @Test
    public void test(){
        System.out.println(threeSumClosest(new int[]{-3, -2, -5,3, -4}, -1));
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                res = Math.abs(target - sum) < Math.abs(target - res) ? sum : res;
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return res;
                }
            }
        }
        return res;
    }
}

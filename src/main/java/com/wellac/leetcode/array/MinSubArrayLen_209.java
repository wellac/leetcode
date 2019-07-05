package com.wellac.leetcode.array;

import org.junit.Test;

/**
 * 209. 长度最小的子数组
 */
public class MinSubArrayLen_209 {

    @Test
    public void test() {
        int[] arr = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, arr));
    }

    public int minSubArrayLen(int s, int[] nums) {
        int start = 0, end = -1;//nums[start...end]作为滑动窗口
        int sum = 0;//滑动窗口内的元素之和
        int res = nums.length + 1;//最小的连续子数组的元素个数

        while (start < nums.length) {
            if (end + 1 < nums.length && sum < s) {
                sum += nums[++end];
            } else {
                sum -= nums[start++];
            }

            if (sum >= s) {
                res = Math.min(res, end - start + 1);
            }
        }

        return res == nums.length + 1 ? 0 : res;
    }
}

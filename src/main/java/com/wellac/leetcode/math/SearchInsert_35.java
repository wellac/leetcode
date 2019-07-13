package com.wellac.leetcode.math;

/**
 * 35. 搜索插入位置
 */
public class SearchInsert_35 {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}

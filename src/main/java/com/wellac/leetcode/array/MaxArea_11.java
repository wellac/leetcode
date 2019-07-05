package com.wellac.leetcode.array;

/**
 * 11. 盛最多水的容器
 */
public class MaxArea_11 {
    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1, max = 0;

        while (start < end) {
            max = Math.max(max, (end - start) * Math.min(height[start], height[end]));
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return max;
    }
}

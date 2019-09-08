package com.wellac.leetcode.array;

/**
 * 11. 盛最多水的容器
 */
public class MaxArea_11 {
    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1, max = 0;

        while (start < end) {
            max = Math.max(max, (end - start) * Math.min(height[start], height[end]));
            /**
             * 情形1：一高一矮
             *      移动较矮的一侧（相较于暴力法，过滤掉移动较高侧无法带来增益的情形）
             * 情形2：两侧同高
             *      同时移动两侧（移动任何一侧都无法带来增益）
             */
            if (height[start] < height[end]) {
                start++;
            } else if (height[start] > height[end]) {
                end--;
            } else {
                start++;
                end--;
            }
        }

        return max;
    }
}

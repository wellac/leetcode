package com.wellac.leetcode.array;

import org.junit.Test;

/**
 * 4. 寻找两个有序数组的中位数
 */
public class FindMedianSortedArrays_4 {

    @Test
    public void test() {
        System.out.println(findMedianSortedArrays(new int[]{4, 5}, new int[]{1, 2, 3}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        //防止二分搜索时m2在越界
        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        //用二分搜索法求数组num1中放在左边区的个数
        int min = 0;//最少放0个
        int max = len1;//最多放len1个

        while (min < max) {
            int m1 = min + (max - min) / 2;       //num1中放在左边区的个数
            int m2 = (len1 + len2 + 1) / 2 - m1;   //num2中放在左边区的个数
            if (nums1[m1] < nums2[m2 - 1]) {
                min = m1 + 1;
            } else {
                max = m1;
            }
        }

        int m1 = max;
        int m2 = (len1 + len2 + 1) / 2 - m1;

        int c1 = Math.max(m1 == 0 ? Integer.MIN_VALUE : nums1[m1 - 1], m2 == 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);
        if ((len1 + len2) % 2 == 1) {
            return c1;
        }

        int c2 = Math.min(m1 == len1 ? Integer.MAX_VALUE : nums1[m1], m2 == len2 ? Integer.MAX_VALUE : nums2[m2]);
        return (c1 + c2) * 0.5;
    }
}

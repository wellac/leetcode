package com.wellac.leetcode.array;

/**
 * 88. 合并两个有序数组
 */
public class Merge_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (m > 0 && n > 0) {
                if (nums1[m - 1] > nums2[n - 1]) {
                    nums1[i] = nums1[--m];
                } else {
                    nums1[i] = nums2[--n];
                }
            } else if (m <= 0) {
                nums1[i] = nums2[--n];
            } else {
                break;
            }

        }
    }
}

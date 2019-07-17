package com.wellac.leetcode.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    @Test
    public void test() {
        int[] arr = {3, 6, 5, 4, 8, 7, 1, 2};
        sort(arr);
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        sort(arr1);
    }

    public int[] sort(int[] arr) {
        boolean f; // 交换标志
        int temp;// 用来交换的临时数
        // 要遍历的次数
        for (int i = 0; i < arr.length - 1; i++) {
            f = false;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    f = true;
                }
            }
            // 如果标志为false，说明本轮遍历没有交换，已经是有序数列，可以结束排序
            if (!f) break;
        }
        return arr;
    }
}

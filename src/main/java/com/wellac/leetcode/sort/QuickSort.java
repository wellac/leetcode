package com.wellac.leetcode.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    @Test
    public void test() {
        int[] arr = {1, 4, 2, 3, 7, 5, 6, 8};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private void sort(int[] arr, int left, int right) {
        if (left > right) return;

        int mid = partition(arr, left, right);

        sort(arr, left, mid - 1);
        sort(arr, mid + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int baseValue = arr[left];//设置基准
        int baseIndex = left;//记录基准的下标
        while (left < right) {
            while (arr[right] >= baseValue && left < right) {
                right--;
            }
            while (arr[left] <= baseValue &&left < right  ) {
                left++;
            }
            if (left != right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        if(left!=baseIndex){
            arr[baseIndex] = arr[left];
            arr[left] = baseValue;
        }
        return left;
    }
}

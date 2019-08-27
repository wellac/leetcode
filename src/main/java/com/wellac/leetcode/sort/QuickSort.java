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
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int i = start;
        int j = end;
        while (i < j) {
            while (arr[j] >= arr[start] && i < j) {
                j--;
            }
            while (arr[i] <= arr[start] && i < j) {
                i++;
            }
            if (i != j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i != start) {
            int temp = arr[i];
            arr[start] = arr[i];
            arr[i] = temp;
        }
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }
}

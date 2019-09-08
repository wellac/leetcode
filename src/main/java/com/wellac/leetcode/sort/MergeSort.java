package com.wellac.leetcode.sort;

import org.junit.Test;

public class MergeSort {

    @Test
    public void test() {

        int[] arr = new int[]{9, 0, 4, 6, 3, 2, 5, 7, 9};
        sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public void sort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                temp[t++] = arr[j++];
            } else {
                temp[t++] = arr[i++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }

        for (int k = 0; k < temp.length; k++) {
            arr[left + k] = temp[k];
        }

    }
}

package com.wellac.leetcode.array;

import org.junit.Test;

/**
 * 215. 数组中的第K个最大元素
 */
public class FindKthLargest_215 {

    @Test
    public void test() {
        int[] arr = new int[]{-1, 2, 0};

        System.out.println(findKthLargest(arr, 1));

    }

    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1, mid = -1;

        while (left <= right) {
            mid = partition(nums, left, right);
            if (mid == k - 1) {
                return nums[mid];
            } else if (mid < k - 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    private int partition(int[] num, int left, int right) {

        //设置最左边的元素为基准值
        int key = num[left];

        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i = left;
        int j = right;

        while (i < j) {
            //j向左移，直到遇到比key小的值
            while (num[j] <= key && i < j) {
                j--;
            }
            //i向右移，直到遇到比key大的值
            while (num[i] >= key && i < j) {
                i++;
            }
            //i和j指向的元素交换
            if (i < j) {
                swap(num, i, j);
            }
        }

        swap(num, left, i);
        return i;
    }

    private void swap(int[] arr, int e1, int e2) {
        int temp = arr[e1];
        arr[e1] = arr[e2];
        arr[e2] = temp;
    }
}

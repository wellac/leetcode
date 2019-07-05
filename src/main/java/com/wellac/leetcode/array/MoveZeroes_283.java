package com.wellac.leetcode.array;

import org.junit.Test;

/**
 * 283. 移动零
 */
public class MoveZeroes_283 {

    @Test
    public void test(){
        int[] arr = new int[]{0,1,0,2,0,3,0,4,0};
        moveZeroes(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                j++;
            }
        }
    }
}

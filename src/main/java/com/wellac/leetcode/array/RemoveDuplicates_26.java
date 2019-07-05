package com.wellac.leetcode.array;

/**
 * 26. 删除排序数组中的重复项
 */
public class RemoveDuplicates_26 {


    public int removeDuplicates(int[] nums) {
        int index = 0;//记录最后一个元素下标

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }

        return ++index;
    }
}

package com.wellac.leetcode.array;

/**
 * 80. 删除排序数组中的重复项 II
 */
public class RemoveDuplicates_80 {

    public int removeDuplicates(int[] nums) {
        int index = 0;//记录最后一个元素下标

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index] || (nums[i] == nums[index] &&(index - 1 < 0 || nums[index - 1] != nums[i]))) {
                nums[++index] = nums[i];
            }
        }

        return ++index;

    }
}

package com.wellac.leetcode.array;

/**
 * 27. 移除元素
 */
public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        int end =nums.length-1;
        for (int i = 0; i <= end;) {
            if(nums[i] == val){
                nums[i] = nums[end];
                end--;
            }else {
                i++;
            }
        }
        return end+1;
    }
}

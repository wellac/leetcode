package com.wellac.leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 229. 求众数 II
 */
public class MajorityElement_229 {
    @Test
    public void test(){
        majorityElement(new int[]{1,2,3,4,3,6,3,5,7,3});
    }
    public List<Integer> majorityElement(int[] nums) {
        int first = -1;
        int second = -1;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && second != nums[i]) {
                first = nums[i];
                count1 = 1;
            } else if (count2 == 0 && first != nums[i]) {
                second = nums[i];
                count2 = 1;
            } else if (first == nums[i]) {
                count1++;
            } else if (second == nums[i]) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == first) {
                count1++;
            }
            if (nums[i] == second) {
                count2++;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        if (count1 > nums.length / 3) res.add(first);
        if (count2 > nums.length / 3) res.add(second);
        return res;
    }
}

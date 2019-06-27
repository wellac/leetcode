package com.wellac.leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindDisappearedNumbers_448 {

    @Test
    public void test(){
        int [] arr = new int[]{4,3,2,7,8,2,3,1};
        findDisappearedNumbers(arr);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            nums[i] = nums[temp-1];
            nums[temp-1] = temp;
        }
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=i+1){
                integers.add(i+1);
            }
        }

        return integers;
    }

}

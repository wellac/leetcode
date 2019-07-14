package com.wellac.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 */
public class Subsets_78 {
    @Test
    public void test(){
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),res);
        return res;
    }

    private void backtrack(int[] nums,int start,List<Integer> subset,List<List<Integer>> subsetList){
        subsetList.add(subset);
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(nums,i+1,new ArrayList<>(subset),subsetList);
            subset.remove(subset.size()-1);
        }
    }
}

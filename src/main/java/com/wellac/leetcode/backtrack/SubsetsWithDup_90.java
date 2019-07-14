package com.wellac.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 */
public class SubsetsWithDup_90 {

    @Test
    public void test() {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> subset, List<List<Integer>> subsetList) {
        subsetList.add(subset);
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            subset.add(nums[i]);
            backtrack(nums, i + 1, new ArrayList<>(subset), subsetList);
            subset.remove(subset.size() - 1);
        }
    }
}

package com.wellac.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 */
public class CombinationSum2_40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();

        backtrack(candidates, target, 0, res, new ArrayList<>());

        return res;
    }

    private void backtrack(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> temp) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (target < candidates[i]) break;
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            temp.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, res, temp);

            temp.remove(temp.size() - 1);
        }
    }

}

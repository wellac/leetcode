package com.wellac.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 */
public class CombinationSum_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, res, new ArrayList<>());

        return res;
    }

    /**
     * 找出 candidates 中从start下标开始，可以使数字和为 target 的组合记录在res中。
     */
    private void backtrack(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> temp) {
        //当target等于0时，说明组合成功，记录组合在res中
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[start]) {
                break;
            }
            temp.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}

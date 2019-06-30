package com.wellac.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 */
public class combine_77 {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();

        backtrack(n, k, res, new ArrayList<>());

        return res;
    }

    private void backtrack(int n, int k, List<List<Integer>> res, List<Integer> temp) {
        if (k == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = n; i > 0; i--) {
            temp.add(0, i);
            backtrack(i - 1, k - 1, res, temp);
            temp.remove(0);
        }
    }
}

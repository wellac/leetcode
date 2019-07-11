package com.wellac.leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. 全排列 II
 */
public class PermuteUnique_47 {
    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] used;

    @Test
    public void test() {
        permuteUnique(new int[]{3, 1, 1});
        System.out.println(res);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        permute(nums, new LinkedList<>());
        return res;
    }

    private void permute(int[] nums, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            System.out.println("完成：" + list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    System.out.println("跳过：" + nums[i]);
                    continue;
                }
                System.out.println("添加：" + nums[i]);
                list.add(nums[i]);
                used[i] = true;
                permute(nums, list);
                used[i] = false;
                list.removeLast();
                System.out.println("删除：" + nums[i]);

            }
        }
    }
}

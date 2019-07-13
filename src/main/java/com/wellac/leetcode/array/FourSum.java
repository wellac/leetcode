package com.wellac.leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 */
public class FourSum {

    @Test
    public void test() {
        System.out.println(fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        //创建存放返回结果的列表res
        List<List<Integer>> res = new ArrayList<>();

        //如果数组为空，或者数组元素少于3个直接返回
        if (nums == null || nums.length < 4) {
            return res;
        }

        //将数组从小到大排序
        Arrays.sort(nums);

        //以i,j为基准，在l和r之间找到三数之和等于0的组合
        for (int i = 0; i < nums.length - 3; i++) {
            //如果nums[i]等于nums[i-1],则跳过当次循环，防止重复
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {

                //如果nums[j]等于nums[j-1],则跳过当次循环，防止重复
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                //定义l和r
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum > target) {
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[l], nums[r])));
                        l++;
                        r--;
                        //当nums[l] ==nums[l - 1]时l继续右移，防止重复
                        while (l < r && nums[l] == nums[l - 1]) l++;
                        //nums[r] == nums[r + 1]时l继续左移，防止重复
                        while (l < r && nums[r] == nums[r + 1]) r--;
                    }
                }

            }
        }
        return res;
    }
}

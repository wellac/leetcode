package com.wellac.leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 */
public class ThreeSum_15 {

    @Test
    public void test() {
        System.out.println(threeSum(new int[]{-2, 0, 1, 1, 2}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        //创建存放返回结果的列表res
        List<List<Integer>> res = new ArrayList<>();

        //如果数组为空，或者数组元素少于3个直接返回
        if (nums == null || nums.length < 3) {
            return res;
        }

        //将数组从小到大排序
        Arrays.sort(nums);

        //以i为基准，在l和r之间找到三数之和等于0的组合
        for (int i = 0; i < nums.length - 2; i++) {

            //如果nums[i]大于零，则终止循环
            if (nums[i] > 0) break;

            //如果nums[i]等于nums[i-1],则跳过当次循环，防止重复
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            //定义l和r
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    l++;
                    r--;
                    //当nums[l] ==nums[l - 1]时l继续右移，防止重复
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    //nums[r] == nums[r + 1]时l继续左移，防止重复
                    while (l < r && nums[r] == nums[r + 1]) r--;
                }
            }
        }
        return res;
    }
}

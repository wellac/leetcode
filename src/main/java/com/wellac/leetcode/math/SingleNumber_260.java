package com.wellac.leetcode.math;

/**
 * 260. 只出现一次的数字 III
 */
public class SingleNumber_260 {
    public int[] singleNumber(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        //找到区分两个数的位置
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            mask = mask << i;
            if ((mask & temp) != 0) {
                break;
            }
        }

        int[] res = new int[2];
        for (int num : nums) {
            //分割两部分
            if ((num & mask) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}

package com.wellac.leetcode.array;

import org.junit.Test;

/**
 * 4. 寻找两个有序数组的中位数
 */
public class FindMedianSortedArrays_4 {

    @Test
    public void test() {
        System.out.println(findMedianSortedArrays(new int[]{4, 5}, new int[]{1, 2, 3}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //防止二分搜索时m2在越界
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        double res = 0;//返回的结果

        int len = nums1.length + nums2.length;   //两个数组的总长度

        //用二分搜索法求数组num1中放在左边区的个数的范围[cutL,cutR]
        for (int cutL = 0, cutR = nums1.length; cutL <= cutR; ) {
            int cut1 = cutL + (cutR - cutL) / 2;//num1中放在左边区的个数
            int cut2 = len / 2 - cut1;  //num2中放在左边区的个数,这样当2*(cut1+cut2) <= len(len为偶数时取等号)
            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
            double R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
            if (L1 > R2) {          //cut1应该向左移动
                cutR = cut1 - 1;
            } else if (L2 > R1) {   //cut1应该向右移动
                cutL = cut1 + 1;
            } else {                //找到符合L1<=R2 && L2<=R1的分割点
                if (len % 2 == 1) { //当len为奇数时
                    res = Math.min(R1, R2);
                } else {            //当len为偶数时
                    res = (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
                }
                break;
            }
        }
        return res;
    }
}

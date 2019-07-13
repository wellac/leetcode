package com.wellac.leetcode.math;

import org.junit.Test;

/**
 * 69. x 的平方根
 */
public class mySqrt_69 {

    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            System.out.println(mySqrt(i)+"^2\t:"+i);
        }
    }

    public int mySqrt(int x) {
        long start = 0;
        long end = x;

        while (start < end) {
            long mid = start + (end - start + 1) / 2;
            if (mid * mid > x) {//转long防止整形溢出
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        return (int) (start);
    }
}

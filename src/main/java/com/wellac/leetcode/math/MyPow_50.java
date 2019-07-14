package com.wellac.leetcode.math;

import org.junit.Test;

/**
 * 50. Pow(x, n)
 */
public class MyPow_50 {
    @Test
    public void test() {
        System.out.println(myPow(2, 3));
    }

    //递归解法
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        return fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}

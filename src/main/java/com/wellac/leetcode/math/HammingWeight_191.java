package com.wellac.leetcode.math;

import org.junit.Test;

/**
 * 191. 位1的个数
 */
public class HammingWeight_191 {
    @Test
    public void test() {
        for (int i = 1; i < 100; i++) {
            System.out.println(hammingWeight(i));
        }
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int mask = 1;
        int count = 0;
        for (int i = 1; i <= 32; i++, mask = mask << 1) {
            if ((n & mask) != 0) {
                count++;
            }
        }
        return count;
    }
}

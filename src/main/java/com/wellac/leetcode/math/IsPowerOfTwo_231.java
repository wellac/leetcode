package com.wellac.leetcode.math;

/**
 * 231. 2的幂
 */
public class IsPowerOfTwo_231 {
    public boolean isPowerOfTwo(int n) {
        if (n < 0) return false;
        int num = 0;
        for (int i = 1, mask = 1; i <= 32; i++, mask = mask << 1) {
            if ((n & mask) != 0) {
                num++;
            }
        }
        return num == 1;
    }
}

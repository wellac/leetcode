package com.wellac.leetcode.math;

/**
 * 190. 颠倒二进制位
 */
public class ReverseBits_190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int left = 1 << 31;
        int right = 1;
        for (int i = 0; i < 16; i++, left = left >>> 1, right = right << 1) {
            int l = (n & left) == 0 ? 0 : 1;
            int r = (n & right) == 0 ? 0 : 1;
            if (l != r) {
                n = n ^ left ^ right;
            }
        }
        return n;
    }
}

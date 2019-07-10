package com.wellac.leetcode.array;

import org.junit.Test;

/**
 * 14. 最长公共前缀
 */
public class LongestCommonPrefix_14 {
    @Test
    public void test() {
        System.out.println(longestCommonPrefix(new String[]{"aa", "a"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int max = Integer.MAX_VALUE;

        for (String str : strs) {
            max = Math.min(max, str.length());
        }

        for (int i = 0; i < max; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, max);
    }
}

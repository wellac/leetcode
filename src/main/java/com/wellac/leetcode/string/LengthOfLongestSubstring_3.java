package com.wellac.leetcode.string;

import org.junit.Test;

import java.util.*;

/**
 * 3. 无重复字符的最长子串
 */
public class LengthOfLongestSubstring_3 {

    @Test
    public void test() {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        //(i,j)维护一个无重复元素的字串
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            map.put(s.charAt(j), j);
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}

package com.wellac.leetcode.string;

import org.junit.Test;

import java.util.*;

public class LengthOfLongestSubstring_3 {

    @Test
    public void test() {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring_1(s));
    }

    public int lengthOfLongestSubstring_1(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring_2(String s) {

        if (s.equals("")) return 0;

        List<Character> charList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            charList.add(s.charAt(i));
        }
        int windowSize = new HashSet<>(charList).size();


        while (windowSize != 1) {
            for (int i = 0; i < s.length() - windowSize + 1; i++) {
                if (new HashSet<>(charList.subList(i, i + windowSize)).size() == windowSize) {
                    return windowSize;
                }
            }
            windowSize--;
        }
        return windowSize;
    }
}

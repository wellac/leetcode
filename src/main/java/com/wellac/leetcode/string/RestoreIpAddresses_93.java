package com.wellac.leetcode.string;


import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 93. 复原IP地址
 */
public class RestoreIpAddresses_93 {

    ArrayList<String> res = new ArrayList<String>();

    @Test
    public void test() {
        List<String> s = restoreIpAddresses("25525511135");
        System.out.println(s);
    }

    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, new LinkedList<>());
        return res;
    }

    private void backtrack(String s, int start, LinkedList<String> segments) {
        if (segments.size() == 3) {
            String segment = s.substring(start);
            if (valid(segment)) {
                segments.add(segment);
                res.add(String.join(".", segments));
                segments.removeLast();
            }
            return;
        }

        int end = Math.min(s.length() - 1, start + 3);
        for (int curr = start; curr < end; curr++) {
            String segment = s.substring(start, curr + 1);
            if (!valid(segment)) continue;
            segments.add(segment);
            backtrack(s, curr + 1, segments);
            segments.removeLast();
        }
    }

    private boolean valid(String segment) {
        int m = segment.length();
        if (m > 3)
            return false;
        return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : (m == 1);
    }
}
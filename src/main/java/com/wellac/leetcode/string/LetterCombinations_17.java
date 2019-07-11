package com.wellac.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 */
public class LetterCombinations_17 {
    private String[] arr = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        letterCombinations(digits, 0, new StringBuilder());
        return res;
    }

    private void letterCombinations(String digits, int index, StringBuilder s) {
        if (index >= digits.length()) {
            if (s.length() > 0)
                res.add(s.toString());
            return;
        }
        String temp = arr[digits.charAt(index) - '0'];
        for (int i = 0; i < temp.length(); i++) {
            s.append(temp.charAt(i));
            letterCombinations(digits, index + 1, s);
            s.deleteCharAt(s.length() - 1);//回溯
        }
    }
}

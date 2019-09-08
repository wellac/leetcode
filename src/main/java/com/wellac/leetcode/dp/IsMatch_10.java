package com.wellac.leetcode.dp;

/**
 * 10. 正则表达式匹配
 */
public class IsMatch_10 {
    public boolean isMatch(String text, String pattern) {
        return isMatch(text, pattern, text.length() - 1, pattern.length() - 1);
    }


    public boolean isMatch(String text, String pattern, int i, int j) {
        //当模式串为空时，字符串也为空则匹配成功，否则匹配失败
        if (j < 0) {
            return i < 0;
        }

        //模式串与字符串的末尾是否匹配
        boolean end_match = i >= 0 //匹配成功的前提条件是：字符串不能为空
                && (pattern.charAt(j) == text.charAt(i)     //情形1：字符串与模式串末尾相等
                || pattern.charAt(j) == '.'                 //情形2：模式串末尾为'.'
                //情形3：模式串末尾为'*',并且字符串末尾与模式串前一位相等或者模式串前一位为'.'
                || (pattern.charAt(j) == '*' && (pattern.charAt(j - 1) == text.charAt(i) || pattern.charAt(j - 1) == '.')));

        if (pattern.charAt(j) == '*') {//当模式串的末尾是'*'的情况
            //看有没有可能,剩下的pattern匹配上全部的text（*代表0，去除*及*的前一个字符继续匹配）
            //看有没有可能,剩下的text匹配整个pattern（*代表n,消除一个字符串中匹配的字符继续匹配）
            return (isMatch(text, pattern, i, j - 2) ||
                    (end_match && isMatch(text, pattern, i - 1, j)));
        } else {//没有星星的情况:消除匹配字符继续匹配
            //字符串与模式串的第一位匹配，并且剩下的text,匹配剩下的pattern，则text与pattern匹配
            return end_match && isMatch(text, pattern, i - 1, j - 1);
        }
    }
}

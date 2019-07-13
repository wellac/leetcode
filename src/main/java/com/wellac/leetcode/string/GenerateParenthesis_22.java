package com.wellac.leetcode.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class GenerateParenthesis_22 {

    private List<String> res = new ArrayList<>();

    @Test
    public void test(){
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);
    }

    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(),0,0,n);
        return res;
    }

    public void backtrack(StringBuilder curr, int left, int right, int n) {
        if (curr.length() == n*2){
            res.add(curr.toString());
        }

        if (left<n){
            curr.append("(");
            backtrack(curr,left+1,right,n);
            curr.deleteCharAt(curr.length()-1);
        }
        if (left>right){
            curr.append(")");
            backtrack(curr,left,right+1,n);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}

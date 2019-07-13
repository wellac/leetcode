package com.wellac.leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 118. 杨辉三角
 */
public class Generate_118 {
    @Test
    public void test(){
        List<List<Integer>> generate = generate(7);
        System.out.println(generate);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows==0) return res;
        res.add(Arrays.asList(1));
        if (numRows==1) return res;
        res.add(Arrays.asList(1,1));
        if (numRows==2) return res;
        for (int i = 3; i <= numRows; i++) {
            List<Integer> list = res.get(res.size()-1);
            Integer [] temp = new Integer[i];
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1){
                    temp[j] = 1;
                }else {
                    temp[j] = list.get(j-1)+list.get(j);
                }
            }
            res.add(Arrays.asList(temp));
        }
        return res;
    }
}

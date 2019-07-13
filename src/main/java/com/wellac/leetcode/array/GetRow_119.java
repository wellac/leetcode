package com.wellac.leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 119. 杨辉三角 II
 */
public class GetRow_119 {
    @Test
    public void test(){
        List<Integer> row = getRow(3);
        System.out.println(row);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res = Arrays.asList(1);
        if (rowIndex==0) return res;
        res = Arrays.asList(1,1);
        if (rowIndex==1) return res;
        for (int i = 2; i <= rowIndex; i++) {
            Integer [] temp = new Integer[i+1];
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i ){
                    temp[j] = 1;
                }else {
                    temp[j] = res.get(j-1)+res.get(j);
                }
            }
            res = Arrays.asList(temp);
        }
        return res;
    }
}

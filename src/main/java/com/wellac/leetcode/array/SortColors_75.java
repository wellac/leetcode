package com.wellac.leetcode.array;

import org.junit.Test;

/**
 * 75. 颜色分类
 */
public class SortColors_75 {

    @Test
    public void test(){
        int [] arr = new int[]{2,0,2,1,1,0};
        sortColors_1(arr);
        System.out.println(arr);
    }
    //采用计数排序
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[index++] = i;
            }
        }
    }

    public void sortColors_1(int[] nums) {
        int zero =0;//指向0区域最后一个不为0的下标
        int two = nums.length-1;//指向2区域前一个不为2的下标

        for(int i =0;i<=two;){
            if(nums[i]==0){
                int temp = nums[i];
                nums[i++] = nums[zero];
                nums[zero++] = temp;
            }else if(nums[i]==2){
                int temp = nums[i];
                nums[i] = nums[two];
                nums[two--] = temp;
            }else {
                i++;
            }
        }
    }
}

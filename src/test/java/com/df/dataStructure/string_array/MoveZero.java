package com.df.dataStructure.string_array;

import org.apache.commons.lang3.StringUtils;

/**
 * @author hanyli
 * @date 2020/11/19
 */
public class MoveZero {
    public static void moveZeroes(int[] nums) {
        int begin=-1;
        int end=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                if(begin==-1) {
                    begin = i;
                    end=i;
                }else{
                    end=i;
                }
            }else if(begin!=-1){
                int temp = nums[begin];
                nums[begin]=nums[i];
                nums[i]=temp;
                if(begin==end){
                    begin = i;
                    end=i;
                }else{
                    begin++;
                    end=i;
                }
            }
        }
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{4,2,4,0,0,3,0,5,1,0});
        moveZeroes2(new int[]{4,2,4,0,0,3,0,5,1,0});
    }
    public static void moveZeroes2(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

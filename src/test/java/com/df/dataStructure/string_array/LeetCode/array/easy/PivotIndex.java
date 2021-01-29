package com.df.dataStructure.string_array.LeetCode.array.easy;

import java.util.Arrays;

/**
 * 724. 寻找数组的中心索引
 * 我们是这样定义数组 中心索引 的：
 * 数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果存在中心索引  那么数组可分为三个部分 [[left],[mid],[right]]
 * 那么 total=left+mid+right  其中left==right
 * 所以 total=2 * left + mid
 *
 * @author hanyli
 * @date 2021/1/28
 */
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        //数组总和
        int total = Arrays.stream(nums).sum();
        //左侧元素和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        PivotIndex pivotIndex = new PivotIndex();
        pivotIndex.pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
    }
}

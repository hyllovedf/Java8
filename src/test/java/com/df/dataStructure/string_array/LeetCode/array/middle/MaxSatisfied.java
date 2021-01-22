package com.df.dataStructure.string_array.LeetCode.array.middle;

/**
 * 1052. 爱生气的书店老板
 *
 * @author hanyli
 * @date 2021/1/22
 */
public class MaxSatisfied {
    /**
     * 首先老板不克制自己也有一个基础满意数量  count
     * 那么要求出最大数量  即老板克制自己后所获取额外的满意数量
     * 这个数量是最大的  加起来就是答案
     *
     * count 表示最基础的满意的数量  即老板不克制自己是的数量
     * extraCount  表示窗口内满意的数量
     * extraCountMax 示窗口内满意的数量最大值
     * @param customers
     * @param grumpy
     * @param X
     * @return
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        //用于存储可以争取满意的数量
        int[] arr = new int[customers.length];
        int left = 0, right = 0, count = 0, extraCount = 0, extraCountMax = 0;

        for (int i = 0; i < customers.length; i++) {
            int cr = customers[i];
            if (grumpy[i] == 0) {
                //计算出最基础满意数量
                count += cr;
            } else {
                //将可争取数量放到数组中
                arr[i] = cr;
            }
        }
        //
        while (right < arr.length) {
            int r = arr[right];
            extraCount += r;
            right++;
            //窗口大小为X时 左指针右移
            if (right - left == X) {
                extraCountMax = Math.max(extraCount, extraCountMax);
                int l = arr[left];
                extraCount -= l;
                left++;
            }
        }
        //最终数量为基础数量+额外的最大数量
        return count + extraCountMax;
    }

}

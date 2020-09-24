package com.df.dataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 无序数组排序后相邻最大差值
 * 利用桶排序思想
 * 不进行排序 只记录每个桶的最大和最小值
 * 右边桶的最小值 - 左边桶的最大值  为相邻元素的差值
 */
public class MaxDiffQuestion {
    public static void maxDiff(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i : arr) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }
        //没有差值说明数组元素全部一样
        if (max - min == 0) {
            System.out.println(0);
            return;
        }
        //创建桶
        int bucketNum = arr.length;
        List<Bucket> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new Bucket());
        }
        //桶中赋值
        for (int value : arr) {
            int bucketIndex = (value - min) * (bucketNum - 1) / (max - min);
            Bucket bucket = bucketList.get(bucketIndex);
            if (bucket.min == null || value < min) {
                bucket.min = value;
            }
            if (bucket.max == null || value > max) {
                bucket.max = value;
            }
        }
        //计算差值
        int leftMax = bucketList.get(0).max;
        int diff = 0;
        for (int i = 1; i < bucketList.size(); i++) {
            if (bucketList.get(i).min == null) {
                continue;
            }
            if (bucketList.get(i).min - leftMax > diff) {
                diff = bucketList.get(i).min - leftMax;
            }
            leftMax = bucketList.get(i).max;
        }
        System.out.println(diff);
    }

    public static void main(String[] args) {
        int[] arr = {4,4,4,4,4,4,};
        maxDiff(arr);
    }

    static class Bucket {
        Integer min;
        Integer max;

    }
}

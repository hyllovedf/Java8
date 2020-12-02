package com.df.dataStructure.string_array;

import java.util.ArrayList;
import java.util.List;

/**
 * 164. 最大间距
 * @author hanyli
 * @date 2020/11/26
 */
public class MaximumGap {
    public static int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        int bucketNum = nums.length;
        List<Bucket> buckets = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new Bucket());
        }
        for (int num : nums) {
            int index = (num - min) * (bucketNum - 1) / (max - min);
            Bucket bucket = buckets.get(index);
            if (bucket.min == null || num < bucket.min) {
                bucket.min = num;
            }
            if (bucket.max == null || bucket.max < num) {
                bucket.max = num;
            }
        }
        int leftmax = buckets.get(0).max;
        int diff = 0;
        for (int i = 1; i < buckets.size(); i++) {
            if (buckets.get(i).min==null) {
                continue;
            }
            if (buckets.get(i).min - leftmax > diff) {
                diff = buckets.get(i).min - leftmax;
            }
            leftmax = buckets.get(i).max;
        }
        return diff;
    }

    static class Bucket {
        Integer min;
        Integer max;
    }
}

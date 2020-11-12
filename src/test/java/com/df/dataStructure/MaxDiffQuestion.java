package com.df.dataStructure;

import java.io.DataInput;
import java.util.*;

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
        int[] arr = {4,2,4,5,9,22,};
        maxDiff(arr);
        int[][] points = {{1, 5}, {1, 70}, {3, 1000}, {55, 700}, {999876789, 53}, {987853567, 12}};
        System.out.println(maxWidthOfVerticalArea(points));

        System.out.println((7>>1));
        sortByBits(new int[]{7});
    }
    public static int[] sortByBits(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int x : arr) {
            list.add(x);
        }
        int[] bit = new int[10001];
        for (int i = 1; i <= 10000; ++i) {
            bit[i] = bit[i >> 1] + (i & 1);
        }
        list.sort((x, y) -> {
            if (bit[x] != bit[y]) {
                return bit[x] - bit[y];
            } else {
                return x - y;
            }
        });
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    public static int maxWidthOfVerticalArea(int[][] points) {

        List<Integer> list = new ArrayList<>();
        for(int[] arr:points){
            list.add(arr[0]);
        }
        Collections.sort(list);
        int max = 0;
        for (int i = 0; i < list.size()-1; i++) {

            int diff = list.get(i + 1) - list.get(i);
            if (diff > max) {
                max = diff;
            }
        }
        return max;
    }
    static class Bucket {
        Integer min;
        Integer max;

    }
}

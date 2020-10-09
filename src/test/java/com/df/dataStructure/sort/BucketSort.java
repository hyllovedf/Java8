package com.df.dataStructure.sort;

import java.util.*;

/**
 * 桶排序  时间复杂度O(n) 空间复杂度O(n)
 * 将数据按照区间放到各个桶中 然后对桶中的数据分别排序 再顺序输出
 * @author hanyli
 * @date 2020/9/22
 */
public class BucketSort {
    public static void bucketSort(double[] arr) {
        //得到最大和最小值
        double max = arr[0];
        double min = arr[0];
        for (double d : arr) {
            if (d > max) {
                max = d;
            }
            if (d < min) {
                min = d;
            }
        }
        //初始化桶
//        int bucketNum = (int) ((max - min) / arr.length + 1);
        int bucketNum = arr.length;
        List<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }
        //遍历数组  将数据放入对应桶中
        for (double v : arr) {
//            int num = (int) ((v - min) / arr.length);
            int num = (int) ((v - min) * (bucketNum - 1) / (max - min));
            bucketList.get(num).add(v);
        }
        //每个桶排序
        double[] sortedArr = new double[arr.length];
        int index = 0;
        for (LinkedList<Double> bucket : bucketList) {
            Collections.sort(bucket);
            for (Double aDouble : bucket) {
                sortedArr[index] = aDouble;
                index++;
            }
        }
        Map map = new HashMap();
        System.out.println(Arrays.toString(sortedArr));
    }

    public static void main(String[] args) {
        double[] arr = {3.4, 5.6, 9.9, 10.4, 2, 1.2};
        bucketSort(arr);
    }
}

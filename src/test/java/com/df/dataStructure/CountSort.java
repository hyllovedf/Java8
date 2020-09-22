package com.df.dataStructure;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 计数排序
 * 适用于一定取值范围内的排序
 * 取值范围过大会导致创建的数组过大  浪费内存
 * 只适用于整数排序
 *
 * @author hanyli
 * @date 2020/9/22
 */
public class CountSort {
    public static void countSort(int[] arr) {
        //确定出取值范围
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        //创建计数数组  统计对应元素的个数
        int[] countArr = new int[max - min + 1];
        for (int value : arr) {
            countArr[value - min]++;
        }
        System.out.println(Arrays.toString(countArr));
        //统计数组变形  后面的元素等于前面元素之和  用于确定排序位置  相等的两个数保证是原顺序
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i - 1];
        }
        System.out.println(Arrays.toString(countArr));
        //创建输出数组  倒序遍历原数组  倒序是为了保证相等的数按照原顺序排序
        int[] sortedArr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sortedArr[countArr[arr[i] - min] - 1] = arr[i];
            countArr[arr[i] - min]--;
        }
        System.out.println(Arrays.toString(sortedArr));
    }

    public static void main(String[] args) {
        int[] arr = {90, 99, 95, 92, 97, 91};
        countSort(arr);
    }
}

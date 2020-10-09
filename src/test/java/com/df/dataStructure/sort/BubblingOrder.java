package com.df.dataStructure.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author hanyli
 * @date 2020/9/18
 */
public class BubblingOrder {
    /**
     * 普通方法
     *
     * @param arr
     */
    public static void simple(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 有的时候不需要经过所有轮排序就已经是一个有序的了  后面就不需要再继续了
     * 实际上中间确定有序之后  还会执行一轮  然后才能跳出循环
     * @param arr
     */
    public static void optimizeOne(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    //有元素交换 说明还不是有序的
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 再次优化的点 在于数据有序区的界定
     * 比如 3,4,2,1,5,6,7,8 从5开始就是一个有序区  不需要再去判定是否要交换
     * 有序区的确定就是最后一次交换的位置, 后面没有交换说明以后的元素已经是有序的
     * @param arr
     */
    public static void optimizeTwo(int[] arr) {
        int lastExchangeIndex = 0;
        int sorted = arr.length - 1;
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {

            boolean isSorted = true;
             for (int j = 0; j < sorted; j++) {
                count++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            sorted = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(count);
    }
    public static void main(String[] args) {
//        int[] arr = {5,8,6,3,9,2,1,7};
        int[] arr = {2, 1, 3, 5, 6, 7, 8, 9};
//        simple(arr);
//        optimizeOne(arr);
        optimizeTwo(arr);
    }
}

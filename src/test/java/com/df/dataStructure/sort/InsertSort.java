package com.df.dataStructure.sort;

import java.util.Arrays;

/**
 * @author hanyli
 * @date 2021/2/21
 */
public class InsertSort {
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insert = arr[i];
            int index = i - 1;
            while (index >= 0 && insert < arr[index]) {
                arr[i] = arr[index--];
            }
            arr[index + 1] = insert;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 6};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

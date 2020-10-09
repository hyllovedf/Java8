package com.df.dataStructure.tree;

import java.util.Arrays;

/**
 * @author hanyli
 * @date 2020/9/18
 * [1, 20, 1, 654, 5, 66, 4, 22, 43]
 */
public class BinaryHeap {
    public static void upAdjust(int[] arr) {
        int childIndex = arr.length - 1;
        int temp = arr[childIndex];
        while (childIndex > 0 ) {
            int parentIndex = (childIndex - 1) >>> 1;
            if (temp >= arr[parentIndex]) {
                break;
            }
            arr[childIndex] = arr[parentIndex];
            childIndex = parentIndex;
        }
        arr[childIndex] = temp;
        System.out.println(Arrays.toString(arr));
    }

    public static void downAdjust(int[] arr, int parentIndex, int length) {
        int temp = arr[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && arr[childIndex + 1] > arr[childIndex]) {
                childIndex++;
            }
            if (temp >= arr[childIndex]) {
                break;
            }
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        arr[parentIndex] = temp;
    }

    public static void buildHeap(int[] arr) {
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            downAdjust(arr,i,arr.length);
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int[] arr = {20, 654, 1, 43, 5, 66, 4, 2, 1};
        upAdjust(arr);
        buildHeap(arr);
    }
}

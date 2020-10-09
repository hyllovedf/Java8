package com.df.dataStructure.sort;

import java.util.Arrays;

/**
 * 堆排序
 * @author hanyli
 * @date 2020/9/21
 */
public class HeapSort {
    public static void downAdjust(int[] arr, int parentIndex, int length) {
        int childIndex = 2 * parentIndex + 1;
        int temp = arr[parentIndex];
        while (childIndex < length) {
            if (childIndex + 1 < length && arr[childIndex] < arr[childIndex + 1]) {
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

    /**
     *利用最大/小堆特性  堆顶元素是最大/小的
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        //将无序数组调整为最大堆
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            downAdjust(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));
        //循环删除堆顶元素  (其实就是最后一个和第一个元素交换) 就是最大的排到了最后
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            downAdjust(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 22, 676, 0, 2, 1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

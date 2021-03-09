package com.df.dataStructure.sort;

import com.df.functional.Data;

import java.util.Arrays;

/**
 * @author hanyli
 * @date 2021/2/24
 */
public class MerageSort {
    public static void merageSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (right - left) / 2 + left;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merage(arr, left, mid, right);
    }

    private static void merage(int[] arr, int left, int mid, int right) {
        int right_temp = mid + 1;
        int[] temp = new int[arr.length];
        int index = left;
        int left_temp = left;
        while (left_temp <= mid && right_temp <= right) {
            if (arr[left_temp] <= arr[right_temp]) {
                temp[index++] = arr[left_temp++];
            } else {
                temp[index++] = arr[right_temp++];
            }
        }
        while (left_temp <= mid) {
            temp[index++] = arr[left_temp++];
        }
        while (right_temp <= right) {
            temp[index++] = arr[right_temp++];
        }
        while (left <= right) {
            arr[left] = temp[left++];
        }
    }
    public static void main(String[] args) {
        int[] arr = {90, 99, 95, 92, 97, 91};
        merageSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

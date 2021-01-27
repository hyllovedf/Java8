package com.df.dataStructure.string_array.LeetCode.array.middle;

/**
 * 978. 最长湍流子数组
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 * <p>
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 *
 * @author hanyli
 * @date 2021/1/25
 */
public class MaxTurbulenceSize {
    public int maxTurbulenceSize(int[] arr) {
        int len = 1;
        int left = 0;
        for (int i = 1; i < arr.length; i++) {
            int compare = Integer.compare(arr[i - 1], arr[i]);
            if (i == arr.length - 1 || compare * Integer.compare(arr[i], arr[i + 1]) != -1) {
                if (compare!=0) len = Math.max(len, i - left + 1);
                left = i;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        MaxTurbulenceSize tur = new MaxTurbulenceSize();

        tur.maxTurbulenceSize(new int[]{4,8,12,16});
    }
}

package com.df.dataStructure.string_array.LeetCode.array.middle;

/**
 * 1004. 最大连续1的个数 III
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * <p>
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 * @author hanyli
 * @date 2021/1/22
 */
public class LongestOnes {
    public int longestOnes(int[] A, int K) {
        int left = 0, right = 0, len = 0;
        while (right < A.length) {
            int r = A[right];
            right++;
            if (r == 0) K--;
            //处理开头是0 K初始为0情况
            if (K < 0) {
                left++;
                K++;
                continue;
            }
            //如果下一个数为0  开始收缩窗口 直到可以后移
            while (K == 0 && right < A.length && A[right] == 0) {
                len = Math.max(len, right - left);
                int l = A[left];
                left++;
                if (l == 0) K++;
            }

        }
        //考虑到没有走到while循环里的情况  比如全为0
        return Math.max(len, right - left);
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 0, 0};
        LongestOnes longestOnes = new LongestOnes();
        longestOnes.longestOnes(arr, 0);
    }
}

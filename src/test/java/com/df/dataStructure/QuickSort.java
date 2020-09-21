package com.df.dataStructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 快速排序
 * 分治法思想  时间复杂度 O(nlogn)  最坏情况 O(n²)
 * @author hanyli
 * @date 2020/9/21
 */
public class QuickSort {
    public static int partitioin(int[] arr, int startIndex, int end) {
        int pivot = arr[startIndex];
        int left = startIndex + 1;
        int right = end;
        while (left != right) {
            while (left < right && arr[right] > pivot) {
                //右指针比基准大  继续左移
                right--;
            }
            while (left < right && arr[left] < pivot) {
                //左指针比基准小  向右移
                left++;
            }
            //交换左右指针值
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }

    /**
     * 双边循环法  分区
     * 1使用左右两个指针  如果右指针指向元素 > 基准 右指针左移 继续比较
     * 2如果小于基准  右指针停止移动
     * 3左指针指向 < 基准 左指针右移
     * 4直到大于基准  左指针停止移动
     * 5然后交换左右指针元素
     * 继续以上操作  直到左右指针重合
     * 最后将基准与左指针交换
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int partitioin = partitioin(arr, start, end);
        quickSort(arr, start, partitioin - 1);
        quickSort(arr, partitioin + 1, end);
    }

    public static void quickSort2(int[] arr,int start,int end) {
        if (start >= end) {
            return;
        }
        int mark = partitioin2(arr, start, end);
        quickSort2(arr, start, mark - 1);
        quickSort2(arr, mark + 1, end);
    }

    /**
     * 单边循环分区
     * 遍历数组 如果大于基准继续遍历
     * 如果小于基准 mark标记右移  交换mark位置元素与当前元素
     * 最后mark位置与基准交换
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private static int partitioin2(int[] arr,int start,int end) {
        int pivot = arr[start];
        int mark = start;
        for (int i = start +1; i <= end; i++) {
            if (arr[i] < pivot) {
                mark++;
                int temp = arr[mark];
                arr[mark] = arr[i];
                arr[i] = temp;
            }
        }
        arr[start] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    public static void quickSortStack(int[] arr, int start, int end) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> root = new HashMap<>();
        root.put("start", start);
        root.put("end", end);
        stack.push(root);
        while (!stack.isEmpty()) {
            Map<String, Integer> pop = stack.pop();
            int mark = partitioin2(arr, pop.get("start"), pop.get("end"));
            if (pop.get("start") < mark - 1) {
                Map<String, Integer> left = new HashMap<>();
                left.put("start", pop.get("start"));
                left.put("end", mark - 1);
                stack.push(left);
            }
            if (pop.get("end") > mark + 1) {
                Map<String, Integer> right = new HashMap<>();
                right.put("start", pop.get("start"));
                right.put("end", mark - 1);
                stack.push(right);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 66, 1, 8, 9, 0};
        quickSortStack(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

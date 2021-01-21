package com.df.dataStructure.string_array.LeetCode.string.hard;

import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 *
 * @author hanyli
 * @date 2021/1/21
 */
public class MaxSlidingWindow {
    /**
     * 返回数组长度肯定是  length()-k+1
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        //利用优先队列 获取最大值
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });
        int left = 0, right = 0;
        int index = 0;
        while (right < nums.length) {
            int rn = nums[right];
            queue.offer(new int[]{rn, right});
            right++;
            if (right - left == k) {
                left++;
                ans[index++] = queue.peek()[0];
                //如果堆顶是left之前的元素  需要移除
                while (!queue.isEmpty() && queue.peek()[1] < left) {
                    queue.poll();
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxSlidingWindow sl = new MaxSlidingWindow();
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};

        sl.maxSlidingWindow(arr, 3);
    }
}

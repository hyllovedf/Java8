package com.df.dataStructure.stack_queue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * @author hanyli
 * @date 2021/3/5
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        //利用优先队列  按照频率排序
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int count = 1;
        int pre = nums[0];
        boolean flag = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) {
                flag = true;
                count++;
            } else {
                queue.add(new int[]{pre, count});
                pre = nums[i];
                flag = i == nums.length - 1;
                count = 1;
            }
        }
        if (flag) {
            queue.add(new int[]{pre, count});
        }
        int[] res = new int[k];
        int index = 0;
        while (k-- > 0) {
            res[index++] = queue.poll()[0];

        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        topKFrequent.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }
}

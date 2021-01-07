package com.df.dataStructure.string_array;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author hanyli
 * @date 2020/11/19
 */
public class MoveZero {
    public static void moveZeroes(int[] nums) {
        int begin = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (begin == -1) {
                    begin = i;
                    end = i;
                } else {
                    end = i;
                }
            } else if (begin != -1) {
                int temp = nums[begin];
                nums[begin] = nums[i];
                nums[i] = temp;
                if (begin == end) {
                    begin = i;
                    end = i;
                } else {
                    begin++;
                    end = i;
                }
            }
        }
    }

    public static boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int x : nums) {
            if (!map.containsKey(x)) {
                map.put(x, new PriorityQueue<>());
            }
            if (map.containsKey(x - 1)) {
                int prevLength = map.get(x - 1).poll();
                if (map.get(x - 1).isEmpty()) {
                    map.remove(x - 1);
                }
                map.get(x).offer(prevLength + 1);
            } else {
                map.get(x).offer(1);
            }
        }
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            PriorityQueue<Integer> queue = entry.getValue();
            if (queue.peek() < 3) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isPossible(new int[]{1, 2, 3, 4, 4, 5, 5, 6});
        moveZeroes(new int[]{4, 2, 4, 0, 0, 3, 0, 5, 1, 0});
        moveZeroes2(new int[]{4, 2, 4, 0, 0, 3, 0, 5, 1, 0});
    }

    public static void moveZeroes2(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

package com.df.dataStructure.string_array.LeetCode.array.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums
 * 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组
 *
 * 比三数之和多了一层循环
 * 需要注意的是去重逻辑
 *
 * @author hanyli
 * @date 2021/2/20
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = nums[i] + nums[j];
                if (temp >= 0 && temp > target) {
                    break;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (temp + nums[left] + nums[right] > target) {
                        right--;
                    } else if (temp + nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        ans.add(list);
                        //去重
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                    //去重
                    while (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                        j++;
                    }
                }
                //去重
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
//        fourSum.fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0);
        fourSum.fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11);
    }
}

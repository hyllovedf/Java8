package com.df.dataStructure.string_array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * <p>
 * 两个区间A B无非有三种情况
 * 两区间没有交集 : 要么A在 B左侧  要么A在B右侧
 * 有交集: 此时两个区间需要融合成一个区间  区间左边取最小 右边取最大 [1,5] [3,6] --> [1,6]
 * <p>
 * 整体流程:
 * 遍历源区间数组  判断新区间与当前区间的情况
 * 如果没有交集  并且新区间在当前区间的左侧  此时就可以直接放置区间  但是需要保证只被放置一次
 * 如果在右侧  需要继续判断与后续的区间的情况
 * 如果有交集  融合后的新区间向后继续判断和其他区间有没有交集 直到没有交集
 * 最后需要保证新区间被放置一次
 *
 * @author hanyli
 * @date 2020/11/4
 */
public class InsertArray {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean needPlace = true;
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                //新区间在当前区间的左侧
                if (needPlace) {
                    //保证只被放置一次
                    res.add(new int[]{left, right});
                    needPlace = false;
                }
                res.add(interval);
            } else if (interval[1] < left) {
                //新区间在当前区间的右侧  需要继续判断有后续区间的情况
                res.add(interval);
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (needPlace) {
            res.add(new int[]{left, right});
        }
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] a = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
//        int[][] insert = insert(a, new int[]{6, 8});
        int[][] insert = reconstructQueue(a);
        System.out.println(Arrays.deepToString(insert));
        int[] arr = {3, 2,5, 6};
        int[] brr = {4, 4, 1, 5, 1};
//        canCompleteCircuit(arr, brr);
        mostCompetitive(arr, 2);

    }
    public static int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            //当前元素比队尾元素小，将队尾元素出栈
            //此处需要另外判断数组剩余长度够不够填满栈，不然最后答案长度可能会小于k
            while (nums[i] < stack.peek() && k - stack.size() + 1 < len - i) {
                stack.pop();
            }
            if (stack.size() < k + 1) {
                stack.add(nums[i]);
            }
        }

        int[] ret = new int[k];

        while (k > 0) {
            ret[--k] = stack.pop();
        }

        return ret;
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] != person2[0]) {
                return person1[0] - person2[0];
            } else {
                return person2[1] - person1[1];
            }
        });
        int n = people.length;
        int[][] ans = new int[n][];
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < n; ++i) {
                if (ans[i] == null) {
                    --spaces;
                    if (spaces == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int begin = 0;

        boolean find = false;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] >= cost[i]) {
                int count = 0;
                begin = i;
                for (int j = begin; ; ) {
                    count += gas[j] - cost[j];
                    if (++j == gas.length) j = 0;
                    if (count < 0) {
                        break;
                    }
                    if (j == begin) {
                        find = true;
                        break;
                    }
                }
                if (find) break;
            }
        }
        return find ? begin : -1;
    }
}

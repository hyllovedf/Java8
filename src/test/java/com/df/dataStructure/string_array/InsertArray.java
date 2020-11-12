package com.df.dataStructure.string_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 *
 * 两个区间A B无非有三种情况
 * 两区间没有交集 : 要么A在 B左侧  要么A在B右侧
 * 有交集: 此时两个区间需要融合成一个区间  区间左边取最小 右边取最大 [1,5] [3,6] --> [1,6]
 *
 * 整体流程:
 * 遍历源区间数组  判断新区间与当前区间的情况
 * 如果没有交集  并且新区间在当前区间的左侧  此时就可以直接放置区间  但是需要保证只被放置一次
 *              如果在右侧  需要继续判断与后续的区间的情况
 * 如果有交集  融合后的新区间向后继续判断和其他区间有没有交集 直到没有交集
 *  最后需要保证新区间被放置一次
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
                    res.add(new int[]{left,right});
                    needPlace = false;
                }
                res.add(interval);
            }else if (interval[1] < left) {
                //新区间在当前区间的右侧  需要继续判断有后续区间的情况
                res.add(interval);
            }else {
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
        int[][] a ={{1,5}};
        int[][] insert = insert(a, new int[]{6, 8});
        System.out.println(Arrays.deepToString(insert));
    }
}

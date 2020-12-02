package com.df.dataStructure.string_array;

import org.mockito.internal.matchers.CompareTo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hanyli
 * @date 2020/11/24
 */
public class FindMinArrowShots2 {
    public static int findMinArrowShots(int[][] points) {
        if (points.length==0) return 0;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int pos = points[0][1];
        int count = 0;
        for (int[] point : points) {
            if (point[0] > pos) {
                pos = point[1];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] a = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        findMinArrowShots(a);

    }
}

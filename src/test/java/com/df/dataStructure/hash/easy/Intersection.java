package com.df.dataStructure.hash.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 * @author hanyli
 * @date 2021/1/27
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                res.add(i);
            }
        }
        int[] ints = new int[set.size()];
        int index=0;
        for (Integer integer : res) {
            ints[index++] = integer;
        }
        return ints;
    }
}

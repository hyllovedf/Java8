package com.df.dataStructure.string_array;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

/**
 * 321. 拼接最大数
 *
 * @author hanyli
 * @date 2020/12/2
 */
public class MaxNumber {
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        StringBuilder builder = new StringBuilder();
        int len1 = nums1.length;
        int len2 = nums2.length;
        Stack<Integer> stack = new Stack<>();
        int index1 = 0;
        int index2 = 0;
        while (index1 < len1 && index2 < len2) {

            if (nums1[index1] < nums2[index2]) {
                stack.push(nums2[index2++]);
            }
        }
        return null;
    }
    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }
        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            str = getStr(str, strs[i]);
            if (str.length() == 0) {
                break;
            }
        }
        return str;
    }

    private static String getStr(String str, String str1) {
        int len = Math.min(str.length(), str1.length());
        int index = 0;
        while (index < len && str.charAt(index) == str1.charAt(index)) {
            index++;
        }
        return str.substring(0, index);
    }

    public static void main(String[] args) {
        String s = "yuye";
        test(s);
        System.out.println(s);
        String s1 = longestCommonPrefix(new String[]{"lower", "flow", "flight"});
        System.out.println(s1);
    }

    private static void test(String i) {
        i = "kdshfk";
    }
}

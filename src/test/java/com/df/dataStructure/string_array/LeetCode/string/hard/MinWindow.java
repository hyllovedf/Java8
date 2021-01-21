package com.df.dataStructure.string_array.LeetCode.string.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。
 * 返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * @author hanyli
 * @date 2021/1/21
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        //两个map
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        //valid用于判断当前子串是否已经涵盖t
        int left = 0, right = 0, valid = 0;
        //记录起始区间
        int start = 0;
        int end = Integer.MAX_VALUE;
        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (need.get(r).equals(window.get(r))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                //说明此时子串涵盖t  然后尽可能的缩小窗口
                if (end - start > right - left) {
                    //现有区间长度小于之前的  赋值
                    start = left;
                    end = right;
                }
                char l = s.charAt(left);
                left++;
                if (need.containsKey(l)) {
                    if (need.get(l).equals(window.get(l))) {
                        valid--;
                    }
                    window.put(l, window.get(l) - 1);
                }
            }
        }
        //需要判断end的值
        return end == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }
}

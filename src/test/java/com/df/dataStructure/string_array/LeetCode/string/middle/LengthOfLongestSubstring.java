package com.df.dataStructure.string_array.LeetCode.string.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author hanyli
 * @date 2021/1/21
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, size = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            window.put(r, window.getOrDefault(r, 0) + 1);
            //>1说明有重复数据 所以应该缩小窗口
            while (window.get(r) > 1) {
                char l = s.charAt(left);
                left++;
                window.put(l, window.get(l) - 1);
            }
            right++;
            size = Math.max(size, right - left);
        }
        return size;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring len = new LengthOfLongestSubstring();
        len.lengthOfLongestSubstring("abc");
    }
}

package com.df.dataStructure.string_array.LeetCode.string.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * 395. 至少有K个重复字符的最长子串
 * 找到给定字符串（由小写字符组成）中的最长子串 T ，
 * 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 *
 * @author hanyli
 * @date 2021/1/21
 */
public class LongestSubstring {
    /**
     * 使用滑动窗口只能是 O(n2)
     * //TODO 其他算法
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, len = 0, valid = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            window.put(r, window.getOrDefault(r, 0) + 1);
            if (window.get(r) == k) {
                valid++;
            }
            right++;
            if (valid == window.size()) {
                len = Math.max(len, right - left);
            }
            //右指针到头后  左移一位  重新统计
            if (right == s.length()) {
                left++;
                right = left;
                valid = 0;
                window.clear();
            }
        }
        return len;
    }

    private boolean valid(Map<Character, Integer> window, int k) {
        for (Integer value : window.values()) {
            if (value < k) {
                return false;
            }
        }
        return true;
    }
}

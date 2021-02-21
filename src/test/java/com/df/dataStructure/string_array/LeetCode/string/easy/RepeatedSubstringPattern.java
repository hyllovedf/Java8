package com.df.dataStructure.string_array.LeetCode.string.easy;

import org.apache.commons.lang3.StringUtils;

/**
 * 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * 仍然是基于KMP
 *
 * 字符串最长相等前后缀的长度  next[length - 1] + 1
 * 如果 字符串长度-最长相等前后缀长度  正好可以被数组的长度整除  则说明该字符串有重复的子字符串
 * next[length - 1] != -1 && length % (length - (next[length - 1] + 1)) == 0;
 *
 * @author hanyli
 * @date 2021/2/21
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        int[] next = new int[length];
        getNext(next, s);
        return next[length - 1] != -1 && length % (length - (next[length - 1] + 1)) == 0;
    }

    private void getNext(int[] next, String s) {
        int j = -1;
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern p = new RepeatedSubstringPattern();
        p.repeatedSubstringPattern("abab");
    }
}

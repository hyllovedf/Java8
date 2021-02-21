package com.df.dataStructure.string_array.LeetCode.string.easy;

/**
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * @author hanyli
 * @date 2021/2/21
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        //构造next数组  也就是前缀表  作用是匹配失败后告诉我们重新匹配的开始位置
        //前缀表数值代表当前位置之前的子串前后缀最大相同长度 为了防止死循环 表里的数值统一 减1
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++)  {
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                //当needle和haystack不匹配时  回溯到之前的位置
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                //匹配  统一后移
                j++;
            }
            if (j == needle.length() - 1) {
                //完全匹配后  返回位置
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    private void getNext(int[] next, String needle) {
        //初始化  开始位置为-1
        int j = -1;
        next[0] = j;
        //已经初始化开始位置  所以i从1开始
        for (int i = 1; i < needle.length(); i++) {
            //由于前缀表统一减1 所以使用的时候需要+1
            while (j >= 0 && needle.charAt(i) != needle.charAt(j + 1)) {
                //当前后缀不相同了  向前回溯
                j = next[j];
            }
            if (needle.charAt(i) == needle.charAt(j + 1)) {
                //前后缀相同  i  j 后移
                j++;
            }
            //将前缀的长度(j)赋值给前缀表
            next[i] = j;
        }
    }
}

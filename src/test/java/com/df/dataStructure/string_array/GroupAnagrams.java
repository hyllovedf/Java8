package com.df.dataStructure.string_array;

import java.util.*;

/**
 * 49. 字母异位词分组
 *
 * @author hanyli
 * @date 2020/12/14
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println((char)('9'-'1'));
//        int n = 603253281;
        int n = 332;
        int i = monotoneIncreasingDigits(n);
        System.out.println(i);
    }
    public static int monotoneIncreasingDigits(int N) {
        String s = String.valueOf(N);
        char[] chars = s.toCharArray();
        int i = 1;
        while (i < chars.length && chars[i - 1] <= chars[i]) {
            i++;
        }
        Map<Character, String> map = new HashMap<>();
        if (i < chars.length) {
            while (i > 0 && chars[i - 1] > chars[i]) {
                chars[i-1]--;
                i--;
            }
            while (++i < chars.length) {
                chars[i] = '9';
            }
        }
        return Integer.parseInt(new String(chars));
    }

    private static int isIncrease(int N) {
        String s = String.valueOf(N);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                return i;
            }
        }
        return -1;
    }
}

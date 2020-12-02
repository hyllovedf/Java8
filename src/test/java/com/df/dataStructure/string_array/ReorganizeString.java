package com.df.dataStructure.string_array;

import org.apache.logging.log4j.util.PropertySource;
import org.springframework.util.comparator.Comparators;

import java.util.Arrays;

/**
 * 767. 重构字符串
 *
 * @author hanyli
 * @date 2020/11/30
 */
public class ReorganizeString {
    public static String reorganizeString(String S) {
        int[] arr = new int[26];
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            arr[c - 'a']++;
        }
        char[] temp = new char[S.length()];
        int start = 0;
        int index = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]-- == 0) {
                if (index >= temp.length) {
                    index = ++start;
                }
                continue;
            }
            if (index >= temp.length) return "";
            temp[index] = (char) (i + 'a');
            i--;
            index += 2;
        }
        StringBuilder builder = new StringBuilder();
        for (char c : temp) {
            builder.append(c);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        reorganizeString("vvvlo");
    }
}

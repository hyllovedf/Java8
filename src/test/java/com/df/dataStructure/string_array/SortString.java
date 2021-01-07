package com.df.dataStructure.string_array;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 1370. 上升下降字符串
 *
 * @author hanyli
 * @date 2020/11/25
 */
public class SortString {
    public static String sortString2(String s) {

        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        while (builder.length() < s.length()) {
            for (int i = 0; i < arr.length; i++) {
                build(arr, builder, i);
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                build(arr, builder, i);
            }
        }
        return builder.toString();
    }

    private static void build(int[] arr, StringBuilder builder, int i) {
        if (arr[i] > 0) {
            builder.append((char) (i + 'a'));
            arr[i]--;
        }
    }

    public static String sortString(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c - 'a']++;
        }
        StringBuilder builder = new StringBuilder();


        return getString(arr, true, builder);
    }

    public static String getString(int[] arr, boolean min, StringBuilder builder) {
        boolean empty = true;
        if (min) {
            for (int index = 0; index < arr.length; index++) {
                empty = build(arr, builder, empty, index);
            }
        } else {
            for (int index = arr.length - 1; index >= 0; index--) {
                empty = build(arr, builder, empty, index);
            }
        }
        if (empty) return builder.toString();
        return getString(arr, !min, builder);
    }

    private static boolean build(int[] arr, StringBuilder builder, boolean empty, int index) {
        if (arr[index] != 0) {
            arr[index]--;
            char c = (char) (index + 'a');
            builder.append(c);
            empty = false;
        }
        return empty;
    }

    public static void main(String[] args) {
        String s = "aaaa bbbb cccc ffff";
//        String s1 = sortString2(s);
        System.out.println(Arrays.toString(s.split(" ", 3)));
        Map<Integer, Integer> map = new LinkedHashMap<>(2);
        map.put(1, 1);
        map.put(3, 3);
        map.put(2, 2);
        map.put(3, 2);
        System.out.println(map.get(2));
    }
}

package com.df.dataStructure.string_array;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 43. 字符串相乘
 *
 * @author hanyli
 * @date 2020/11/2
 */
public class StringMultiply {
    public static String multiply(String num1, String num2) {
        int max = Math.max(num1.length(), num2.length());
        int[] res = new int[2 * max];
        int[] a = new int[num1.length()];
        int[] b = new int[num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            a[i] = num1.charAt(num1.length() - 1 - i) - 48;
        }
        for (int i = 0; i < num2.length(); i++) {
            b[i] = num2.charAt(num2.length() - 1 - i) - 48;
        }
        getRes(a, b, res);
        StringBuilder bu = new StringBuilder();
        boolean first = false;
        for (int i = res.length - 1; i >= 0; i--) {
            if (!first) {
                if (res[i] == 0) {
                    continue;
                }
                first = true;
            }
            bu.append(res[i]);
        }
        return bu.toString();
    }

    private static void getRes(int[] a, int[] b, int[] res) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < b.length; i++) {
            int index = i;
            for (int value : a) {
                int temp = res[index];
                int multiply = value * b[i];
                temp += multiply;
                if (temp >= 10) {
                    int shiwei = temp / 10;
                    res[index + 1] += shiwei;
                    temp -= shiwei * 10;
                }
                res[index++] = temp;
            }
        }
    }

    public static void main(String[] args) {
        String multiply = multiply("13", "456");
        System.out.println(multiply);
        String s = "agg bgg aabd";
        int[] arr = {0, 1, 1, 0};
        minCostClimbingStairs(arr);
        System.out.println();
    }

    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int index = 0;
        int count = 0;
        while (index < len) {
            if (index == len - 1) {
                break;
            }
            if (cost[index]<cost[index+1]) {
                count += cost[index];
            }else{
                count += cost[++index];
            }
            index++;
        }
        return count;
    }
}

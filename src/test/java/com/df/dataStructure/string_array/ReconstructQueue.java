package com.df.dataStructure.string_array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 406. 根据身高重建队列
 *
 * @author hanyli
 * @date 2020/11/24
 */
public class ReconstructQueue {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b)->{
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(b[1], a[1]);
            }
        });
        int[][] ints = new int[people.length][];
        for (int[] person : people) {
            int i = person[1]+1;
            for (int j = 0; j < people.length; j++) {
                if (ints[j] == null) {
                    --i;
                    if (i == 0) {
                        ints[j]=person;
                    }
                }
            }
        }

        return ints;
    }

    public static void main(String[] args) {
        char i = 1 + 'a';
        System.out.println(i);
        int[][] a = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        reconstructQueue(a);
    }
}

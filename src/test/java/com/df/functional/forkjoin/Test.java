package com.df.functional.forkjoin;

import org.springframework.scheduling.annotation.Scheduled;

import java.util.stream.LongStream;

/**
 * @author hanyli
 * @date 2020/1/14
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        for (int i = 1; i < 10; i++) {
            int i1 = computeFibonacci(i);
            System.out.println(i1);
        }
        int i = computeFibonacci(5);
        System.out.println(i);

    }
    private static int computeFibonacci(int n) {
// 假设n >= 0
        if (n <= 2) {
            return 1;
        } else {
            int first = 1;
            int second = 1;
            int third = 0;
            for (int i = 3; i <= n; i++) {
// 第三个数是前两个数之和
                third = first + second;
// 前两个数右移
                first = second;
                second = third;
            }
            return third;
        }
    }

    public static long sum(long n) {
        long[] longs = LongStream.rangeClosed(1, n).toArray();
        long sum = 0;
        for (long num : longs) {
            sum += num;
        }
        return sum;
    }
}

package com.df.functional.parallel;

import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * create by hanyli 2019/11/20
 */
public class ParallelStreams {
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static long sequentialRangeSum(long n) {
        return LongStream.rangeClosed(1L, n)
                .reduce(0L, Long::sum);
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long parallelRangeSum(long n) {
        return LongStream.rangeClosed(1L, n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long classicalSum(long n) {
        long result = 0;
        for (long i = 0; i < n; i++) {
            result += i;
        }
        return result;
    }

}

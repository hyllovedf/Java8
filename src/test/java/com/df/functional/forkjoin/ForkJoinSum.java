package com.df.functional.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author hanyli
 * @date 2020/1/14
 */
public class ForkJoinSum extends RecursiveTask<Long> {
    private final long[] numbers;
    private final int start;
    private final int end;

    public static final int THRESHLOD = 10;

    public ForkJoinSum(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinSum(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int len = end - start;
        if (len <= THRESHLOD) {
            return computeSequentially();
        }
        ForkJoinSum left = new ForkJoinSum(numbers, start, start + len / 2);
        left.fork();
        ForkJoinSum right = new ForkJoinSum(numbers, start + len / 2, end);
        Long rightResult = right.compute();
        Long leftResult = left.join();
        return leftResult + rightResult;
    }

    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static long forkJoinSum(long n) {
        long[] longs = LongStream.rangeClosed(1, n).toArray();
        ForkJoinSum forkJoinSum = new ForkJoinSum(longs);
        return new ForkJoinPool().invoke(forkJoinSum);
    }
}

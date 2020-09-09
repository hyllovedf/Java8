package com.df.functional.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author hanyli
 * @date 2020/7/21
 */
public class Febnaci extends RecursiveTask<Integer> {
    int n;

    public Febnaci(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }
        Febnaci f1 = new Febnaci(n - 1);
        Febnaci f2 = new Febnaci(n - 2);
        f1.fork();
        f2.fork();
        return f1.join() + f2.join();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        for (int i = 0; i < 10; i++) {
            Integer invoke = forkJoinPool.invoke(new Febnaci(i));
            System.out.println(invoke);
        }
    }
}

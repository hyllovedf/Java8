package com.df.functional.future;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * create by hanyli 2019/11/28
 */
public class FutureTest {
    private static Random random = new Random();
    public static void main(String[] args) {
        getPriceAsyncFactory("df");
        Future<Double> df = getPriceAsync("df");
        try {
            Double aDouble = df.get();
            System.out.println(aDouble);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static Future<Double> getPriceAsync(String name) {
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(() -> {
            try {
                Double aDouble = calculatePrice(name);
                future.complete(aDouble);
            } catch (Exception e) {
                future.completeExceptionally(e);
            }
        }).start();
        return future;
    }
    public static Future<Double> getPriceAsyncFactory(String name) {
        return CompletableFuture.supplyAsync(()->calculatePrice(name));
    }

    private static Double calculatePrice(String name) {
        int i = 10 / 0;
        return random.nextDouble() * name.charAt(0) + name.charAt(1);
    }
}

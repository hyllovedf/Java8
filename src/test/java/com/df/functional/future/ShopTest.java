package com.df.functional.future;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static java.util.stream.Collectors.*;

/**
 * create by hanyli 2019/11/28
 * 测试同步代码、并行流、completableFuture性能
 * 假设业务是传入商品名称查询同一个商品各个商家的价格
 * 获取价格时延迟一秒，模仿实际调用第三方所用的时间
 */
public class ShopTest {
    /*static {
        List<Shop> shop = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            shop.add(new Shop("BestPrice"));
        }
        shops = shop;
    }*/
//    private static List<Shop> shops;

    private static List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll")
    );
    private static final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        }
    });
    public static void main(String[] args) {
        long start = System.nanoTime();
//        List<String> prices = findPrices("df");//4127
//        findPricesParallel("df");//1174
//        List<String> df = findPricesFuture("df");//2144
//        System.out.println(df);
        List<String> df = findPricesFutureTwo("df");
        System.out.println(df);
        System.out.println((System.nanoTime() - start) / 1000000);
    }

    /**
     * 同步式代码
     *
     * @param product
     * @return
     */
    private static List<String> findPrices(String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(toList());
    }

    /**
     * 并行流
     *
     * @param product
     * @return
     */
    private static List<String> findPricesParallel(String product) {
        return shops.parallelStream()
                .map(shop -> {
                    System.out.println(Thread.currentThread().getName());
                    return String.format("%s price is %.2f", shop.getName(), shop.getPrice(product));
                })
                .collect(toList());
    }

    /**
     * completableFuture
     *
     * @param product
     * @return
     */
    private static List<String> findPricesFuture(String product) {

        List<CompletableFuture<String>> collect = shops.parallelStream()
                .map(shop -> {
                    return CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)),executor);
                })
                .collect(toList());
        return collect.stream().map(CompletableFuture::join).collect(toList());
    }

    public static List<String> findPricesFutureTwo(String product) {
        /*List<CompletableFuture<String>> collect = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPriceStr(product)))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote ->
                        CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote))))
                .collect(toList());*/
        List<CompletableFuture<String>> priceFutures =
                shops.stream()
                        .map(shop -> {
                            System.out.println(Thread.currentThread().getName()+"------");
                            return CompletableFuture.supplyAsync(
                                () -> shop.getPriceStr(product), executor);})
                        .map(future -> future.thenApply(Quote::parse))
                        .map(future -> future.thenCompose(quote ->
                               {
                                   System.out.println(Thread.currentThread().getName()+"====");
                                   return CompletableFuture.supplyAsync(
                                        () -> Discount.applyDiscount(quote), executor);}))
                        .collect(toList());
        return priceFutures.stream().map(CompletableFuture::join).collect(toList());
    }
}

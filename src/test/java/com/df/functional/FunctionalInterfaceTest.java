package com.df.functional;

import java.util.*;
import java.util.concurrent.*;

/**
 * create by hanyli 2019/11/18
 */
public class FunctionalInterfaceTest {
    private static BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);
    private static final Executor executor = new ThreadPoolExecutor(3, 3, 60, TimeUnit.SECONDS, queue, r -> {
        Thread thread = new Thread(r, "ImportExcel-" + nextThreadId());
        thread.setDaemon(true);
        return thread;
    }, new ThreadPoolExecutor.CallerRunsPolicy());
    private static int threadId;

    private static synchronized int nextThreadId() {
        return threadId++;
    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        List<CompletableFuture> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            CompletableFuture test = test(i);
            list.add(test);
        }
        list.forEach(CompletableFuture::join);
        System.out.println(System.currentTimeMillis() - l);
        System.out.println("=========");
    }

    public static CompletableFuture test(int i) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--" + i);
            return "";
        },executor);
    }

    public static void t(List<Data> list) {
        Map<String, List<Data>> parentMap = new HashMap<>();
        List<Data> dataList = new ArrayList<>();
        for (Data data : list) {
            if (!parentMap.containsKey(data.getParent())) {
                dataList = new ArrayList<>();
                parentMap.put(data.getParent(), dataList);
            } else {
                dataList = parentMap.get(data.getParent());
            }
            dataList.add(data);
        }
        System.out.println(parentMap);
            /*let childNodes = []
            console.log(childNodes)
            treeData.forEach(data=>{
            if (!this.parentMap.has(data.parent)) {
                childNodes = []
                console.log(childNodes)
                this.parentMap.set(data.parent, childNodes);
            } else {
                childNodes = this.parentMap.get(data.parent)
            }
            childNodes.push(data)*/
    }
}

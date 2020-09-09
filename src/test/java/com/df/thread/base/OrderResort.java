package com.df.thread.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hanyli
 * @date 2020/3/11
 */
public class OrderResort {


    public static void main(String[] args) throws Exception {
        ReadThread read = new ReadThread();
        WriteThread write = new WriteThread();
        read.start();
        write.start();
        Thread.sleep(10);
        read.interrupt();
    }

    private static int num = 0;
    private static boolean ready = false;

    static class ReadThread extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                if (ready) {
                    System.out.println(num + num);
                }
            }
            System.out.println("read over");
        }
    }

    static class WriteThread extends Thread {
        @Override
        public void run() {
            num = 2;
            ready = true;
            System.out.println("write over");
        }
    }
}


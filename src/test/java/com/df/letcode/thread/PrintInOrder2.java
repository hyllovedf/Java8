package com.df.letcode.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hanyli
 * @date 2020/9/9
 * 确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 */
public class PrintInOrder2 {
    private Semaphore semaphore_two = new Semaphore(0);
    private Semaphore semaphore_three = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphore_two.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore_two.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphore_three.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphore_three.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();

    }

    public static void main(String[] args) throws InterruptedException {
        PrintInOrder2 printInOrder = new PrintInOrder2();
        Thread first = new Thread(() -> {
            try {
                printInOrder.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread second = new Thread(() -> {
            try {
                printInOrder.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread three = new Thread(() -> {
            try {
                printInOrder.third(() -> System.out.println("three"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        first.start();
        three.start();
        second.start();
    }
}

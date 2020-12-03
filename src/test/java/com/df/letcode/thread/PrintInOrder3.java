package com.df.letcode.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author hanyli
 * @date 2020/9/9
 * 确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 */
public class PrintInOrder3 {
    private int i = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition_one = lock.newCondition();
    private Condition condition_two = lock.newCondition();
    private Condition condition_three = lock.newCondition();

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        // printFirst.run() outputs "first". Do not change or remove this line.
        try {
            if (i != 1) {
                condition_one.await();
            }
            printFirst.run();
            i++;
            condition_two.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        // printSecond.run() outputs "second". Do not change or remove this line.
        try {
            if (i != 2) {
                condition_two.await();
            }
            printSecond.run();
            i++;
            condition_three.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        // printThird.run() outputs "third". Do not change or remove this line.
        try {
            if (i != 3) {
                condition_three.await();
            }
            printThird.run();
            i -= 2;
            condition_one.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        PrintInOrder3 printInOrder = new PrintInOrder3();
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

package com.df.functional.AQS;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedWriter;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hanyli
 * @date 2020/3/31
 */
public  class  Test {
    final static NonReentrantLock lock = new NonReentrantLock();
    final static ReentrantLock reentrantLock = new ReentrantLock();
    final static Condition conditionA = lock.newCondition();
    final static Condition conditionB = lock.newCondition();
    final static Condition conditionC = lock.newCondition();
    final static Queue<String> queue = new LinkedBlockingQueue<>();
    final static int queuesize = 10;
    static int flag = 1;

    public static void main(String[] args) throws InterruptedException {
        InputStream resourceAsStream = Test.class.getResourceAsStream("/df.xlsx");
        lock.lock();
        System.out.println("lock");
        new Thread(()->{
            lock.lock();
            System.out.println("zi");
            lock.unlock();
        }).start();
        Thread.sleep(10000);
        lock.unlock();
        System.out.println("realse");
        reentrantLock.lock();
        System.out.println("reentrantLock");
        reentrantLock.lock();
        System.out.println("reentrantLock2");
        reentrantLock.unlock();
        System.out.println("unlock");
        reentrantLock.unlock();
        System.out.println("unlock");

        System.out.println("123");

        int a = 0;
        int b = 1;
        assert a == b; //需显示开启，默认为不开启状态
        assert a == b : "执行失败！";

        System.out.println("1234");
    }

    public synchronized static  void get() {

    }
}

package com.df.functional.AQS;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author hanyli
 * @date 2020/6/2
 */
public class VolatileExample  {
    int a = 0;
    boolean flag = false;
    public void writer() {
        try {
            flag = true; // step 2
            a = 1; // step 1
            Thread.sleep(1000);
            System.out.println("sdd");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void reader() {
        if (flag) { // step 3
            System.out.println(a); // step 4
        }
    }

    public static void main(String[] args) {
        VolatileExample volatileExample = new VolatileExample();
        Thread thread = new Thread(() -> {
            volatileExample.writer();
        });
        Thread thread1 = new Thread(() -> {
            volatileExample.reader();
        });
        thread.start();
        thread1.start();

    }
}

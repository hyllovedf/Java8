package com.df.functional.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author hanyli
 * @date 2020/9/16
 */
public class OrderTest {
    public static void main(String[] args) {
        Student student = new Student();
        Map<Integer,String> map = new LinkedHashMap<>(10,0.75f,true);
//        Map<Integer,String> map = new LinkedHashMap<>();
        map.put(2, "dfdf");
        map.put(1, "df");
        map.put(3, "dfdfdf");
        map.get(2);
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
        }
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            System.out.println("triped go");
        });
        new Thread(()->{
            try {
                cyclicBarrier.await();
                System.out.println("one");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                cyclicBarrier.await();
                System.out.println("two");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                cyclicBarrier.await();
                System.out.println("three");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

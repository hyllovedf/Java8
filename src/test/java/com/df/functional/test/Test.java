package com.df.functional.test;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

/**
 * create by hanyli 2019/12/10
 */
public class Test {
    static class DelayEle implements Delayed {
        private final long delayTime;
        private final long expire;
        private final String name;

        public DelayEle(long delayTime, String name) {
            this.delayTime = delayTime;
            this.name = name;
            expire = System.currentTimeMillis() + delayTime;
        }

        @Override
        public long getDelay(TimeUnit unit) {

            return unit.convert(expire - System.currentTimeMillis(), TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }


    public static void main(String[] args) throws Exception {
        int i = 0;
        retry:
        for (; ; ) {
            System.out.println("loop");

            for (; ; ) {
                System.out.println("inner loop");
                if (i++ > 10) {
                    break retry;
                }
                continue retry;
                // else CAS failed due to workerCount change; retry inner loop
            }
        }
        int COUNT_BITS = Integer.SIZE - 3;
        int RUNNING = 1 << COUNT_BITS;
        int CAPACITY = (1 << COUNT_BITS) - 1;
        /*
        CAPACITY
        ‭00011111111111111111111111111111
        ‭00100000000000000000000000000000‬
        00000000000000000000000000000001
        00011111111111111111111111111111
        ‭00100000000000000000000000000010‬
        00000000000000000000000000000010
        ‬*/
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
//        readLock.lock();
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        new Thread(() -> {

            writeLock.lock();
            try {
                Thread.sleep(2000);
                writeLock.unlock();
                System.out.println("unlock");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
//        writeLock.lock();
        readLock.lock();
        System.out.println(131073);
        System.out.println(CAPACITY);
        System.out.println(RUNNING);
        System.out.println(CAPACITY | 2);
        System.out.println((RUNNING | 2) & CAPACITY);
        System.out.println(RUNNING >>> COUNT_BITS);
        System.out.println((RUNNING | 0) & ~CAPACITY);
        System.out.println(~CAPACITY);

        final int SHARED_SHIFT = 16;
        final int SHARED_UNIT = (1 << SHARED_SHIFT);
        final int MAX_COUNT = (1 << SHARED_SHIFT) - 1;
        final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;
        System.out.println(131073 & EXCLUSIVE_MASK);

        System.out.println(SHARED_UNIT);
        System.out.println((SHARED_UNIT + 1) >>> SHARED_SHIFT);
        System.out.println((SHARED_UNIT + SHARED_UNIT) & SHARED_SHIFT);
        readLock.unlock();
//        Person student = new Student();
//        System.out.println(student instanceof Person);
//        int i = 10;
//        i -= 5 - 2;
//        System.out.println(i);
        DelayQueue<DelayEle> delayeds = new DelayQueue<>();
        delayeds.offer(new DelayEle(10000, "df"));
//        delayeds.poll(2000,TimeUnit.NANOSECONDS);
        long l = System.currentTimeMillis();
        DelayEle take = delayeds.take();
        System.out.println("帆帆帆帆  "+(System.currentTimeMillis() - l));
        /*Set<String> set = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                set.add(getNo());
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(set.size());*/


 /* // 设置类成员属性
        HashMap propertyMap = new HashMap();

        propertyMap.put("id", Class.forName("java.lang.Integer"));

        propertyMap.put("name", Date.class);

        propertyMap.put("address", Class.forName("java.lang.String"));

        // 生成动态 Bean
        Bean bean = new Bean(propertyMap);

        // 给 Bean 设置值
        bean.setValue("id", new Integer(123));

        bean.setValue("name", "454");

        bean.setValue("address", "789");


        // 从 Bean 中获取值，当然了获得值的类型是 Object

        System.out.println("  >> id      = " + bean.getValue("id"));

        System.out.println("  >> name    = " + bean.getValue("name"));

        System.out.println("  >> address = " + bean.getValue("address"));

        // 获得bean的实体
        Object object = bean.getObject();

        // 通过反射查看所有方法名
        Class clazz = object.getClass();

        Method[] methods = clazz.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].getName());
        }*/
    }

    private static String getNo() {
        String orderNo = "";
        UUID uuid = UUID.randomUUID();
        String sdf = new SimpleDateFormat("yyyyMMddHHMMSS").format(new Date());
        orderNo = uuid.toString().substring(0, 8);
        orderNo = orderNo + sdf;
        return orderNo;
    }


}

package com.df.thread.base;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hanyli
 * @date 2020/3/10
 */
public class TestUnsafe {
    static final Unsafe unsafe;
    static final long stateOffset;
    private volatile long state = 0;

    static {
        try {
//            stateOffset = unsafe.objectFieldOffset(TestUnsafe.class.getDeclaredField("state"));
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            stateOffset = unsafe.objectFieldOffset(TestUnsafe.class.getDeclaredField("state"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error();
        }
    }

    static int COUNT_BITS = Integer.SIZE - 3;
    static int CAPACITY = (1 << COUNT_BITS) - 1;

    public static void main(String[] args) {
        /*TestUnsafe testUnsafe = new TestUnsafe();
        boolean b = unsafe.compareAndSwapInt(testUnsafe, stateOffset, 0, 1);
        System.out.println(b);
        System.out.println(testUnsafe.state);*/
        int COUNT_BITS = Integer.SIZE - 3;
        int CAPACITY = (1 << COUNT_BITS) - 1;
        AtomicInteger ctl = new AtomicInteger(ctlOf(-536870911, 0));
        System.out.println(ctl.get());
        System.out.println(runStateOf(ctl.get()));
        System.out.println(workerCountOf(ctl.get()));
    }

    private static int runStateOf(int c) {
        return c & ~CAPACITY;
    }

    private static int workerCountOf(int c) {
        return c & CAPACITY;
    }

    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }
}

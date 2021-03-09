package com.df;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketTest {

    private int count = 100;// 100张票

    @Resource(name = "redisLock")
    private Lock lock;

    @Resource(name = "myRedisTemplate")
    private RedisTemplate redisTemplate;
    private static final String DECR_SCRIPT_CONTENT="local flag = redis.call('exists',KEYS[1]) " +
            "if tonumber(flag)==1 " +
            "then " +
            "local res=redis.call('decr',KEYS[1]) " +
            "return  res " +
            "else " +
            "return -1 " +
            "end";
    private static final RedisScript DECR_SCRIPT = new DefaultRedisScript(DECR_SCRIPT_CONTENT, Long.class);
    private static final String SCRIPT_CONTENT=
            "local flag=redis.call('exists',KEYS[1]) " +
                    "if tonumber(flag)==1 " +
                    "then " +
                    "local count=redis.call('get',KEYS[1]) " +
                    "if tonumber(count)>0 " +
                    "then " +
                    "count=tonumber(count)-1 " +
                    "redis.call('set',KEYS[1],count) " +
                    "return 'SUCESS_GET_AND_STOCKS_IS_'..count " +
                    "else " +
                    "return 'STOCKS_IS_0'" +
                    "end; " +
                    "else " +
                    "return 'NOT_EXISTS' " +
                    "end";
    private static final RedisScript TKGIFT_SCRIPT=new DefaultRedisScript(SCRIPT_CONTENT,String.class);
    @Test
    public void testredis(){
        List<String> keys = new ArrayList<>();
        keys.add("num");

        Object execute = redisTemplate.execute(DECR_SCRIPT, keys);
//        Object execte = redisTemplate.execute(TKGIFT_SCRIPT, keys);
        System.out.println(execute);
    }

    @Test
    public void ticketTest() throws InterruptedException {
        TicketRunnable tr = new TicketRunnable();
        // 四个线程对应四个窗口
        Thread t1 = new Thread(tr, "窗口A");
        Thread t2 = new Thread(tr, "窗口B");
        Thread t3 = new Thread(tr, "窗口C");
        Thread t4 = new Thread(tr, "窗口D");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        Thread.currentThread().join();
    }

    // 线程类模拟一个窗口买火车票
    public class TicketRunnable implements Runnable {

        @Override
        public void run() {
            while (count > 0) {
                lock.lock();
                try {
                    if (count > 0) {
                        System.out.println(Thread.currentThread().getName() + "售出第" + (count--) + "张票");
                    }

                } finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

}

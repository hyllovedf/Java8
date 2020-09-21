package com.df.utils;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author hanyli
 * @date 2020/8/3
 */
@Component
public class RedisLock implements Lock {
    private static final String KEY = "KEY";
    private static final Long L = 1L;
    @Qualifier("myRedisTemplate")
    @Autowired
    private RedisTemplate redisTemplate;
    private static ThreadLocal<String> local = new ThreadLocal<>();
    private static final String DEL_SCRIPT = "if redis.call(\"get\",KEYS[1]) == ARGV[1] then " +
            "    return redis.call(\"del\",KEYS[1]) " +
            "else " +
            "    return 0 " +
            "end";
    private static RedisScript<Long> script = new DefaultRedisScript<>(DEL_SCRIPT,Long.class);

    private static final String SET_SCRIPT = "if redis.call(\"setnx\",KEYS[1],ARGV[1]) == 1 then " +
            "return redis.call(\"expire\",KEYS[1] , 30) " +
            "else return 0 end";
    private static RedisScript<Long> setScript = new DefaultRedisScript<>(SET_SCRIPT,Long.class);

    @Override

    public void lock() {
        while (true) {
            if (tryLock()) {
                break;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        String uuid = UUID.randomUUID().toString();
        Object execute = redisTemplate.execute(setScript, Collections.singletonList(KEY), uuid);

        if (L.equals(execute)) {
            local.set(uuid);
            return true;
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        String value = local.get();
        redisTemplate.execute(script, Collections.singletonList(KEY), value);
        local.remove();
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}

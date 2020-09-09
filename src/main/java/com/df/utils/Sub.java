package com.df.utils;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import java.util.concurrent.CountDownLatch;

/**
 * @author hanyli
 * @date 2020/8/3
 */
public class Sub implements MessageListener {
    private CountDownLatch countDownLatch;
    public Sub(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void onMessage(Message message, byte[] pattern) {
    }
}

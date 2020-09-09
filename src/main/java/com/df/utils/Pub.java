package com.df.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author hanyli
 * @date 2020/8/3
 */
@Component
public class Pub {
    @Autowired
    @Resource(name="redisTemplate")
    private RedisTemplate rt;


    public void sendMessage(String channel, String message) {
        rt.convertAndSend(channel, message);
    }
    public void sendMessage(String channel) {
        rt.convertAndSend(channel, "df");

//        rt.convertAndSend(channel, user);
    }
}

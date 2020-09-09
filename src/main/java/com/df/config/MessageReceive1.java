package com.df.config;

import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @author hanyli
 * @date 2020/8/3
 */
public class MessageReceive1 {
    public void getMessage(String object) {
//序列化对象（特别注意：发布的时候需要设置序列化；订阅方也需要设置序列化）
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        String deserialize = (String) genericJackson2JsonRedisSerializer.deserialize(object.getBytes());
        System.out.println("消息客户端1号：" + deserialize);
    }
}

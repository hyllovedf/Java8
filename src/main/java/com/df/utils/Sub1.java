package com.df.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author hanyli
 * @date 2020/8/3
 */
public class Sub1 implements MessageListener {
    @Autowired
    private StringRedisSerializer stringRedisSerializer;


    /* (非 Javadoc)
     * Description:
     * @see org.springframework.data.redis.connection.MessageListener#onMessage(org.springframework.data.redis.connection.Message, byte[])
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        byte[] body = message.getBody();//请使用valueSerializer
        byte[] channel = message.getChannel();
        String msg = (String)stringRedisSerializer.deserialize(body);
        String topic = (String)stringRedisSerializer.deserialize(channel);
        System.out.println("我是sub,监听"+topic+",我收到消息："+msg);

    }
}

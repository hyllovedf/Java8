package com.df.config;

import org.springframework.stereotype.Component;

/**
 * @author hanyli
 * @date 2020/8/3
 */
@Component
public class MessageReceive2 {
    public void getMessage(String object) {
//序列化对象（特别注意：发布的时候需要设置序列化；订阅方也需要设置序列化）
        System.out.println("消息客户端2号：" + object);
    }
}

package com.df.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @author hanyli
 * @date 2021/3/9
 */
public class Producer {
    public static void main(String[] args) throws Exception {
        testProducer();
    }
    public static void testProducer() throws Exception {
        //创建producer
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer("test");
        //指定nameserver地址
        defaultMQProducer.setNamesrvAddr("192.168.138.128:9876");
        defaultMQProducer.setVipChannelEnabled(false);
        //启动producer
        defaultMQProducer.start();
        for (int i = 0; i < 10; i++) {
            //创建消息 指定topic  tag和消息体
            Message message = new Message("broker-a", "tag1", ("rocketmq" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            //发送消息
            SendResult result = defaultMQProducer.send(message,10000000);
            System.out.println(result);
        }
        defaultMQProducer.shutdown();
    }
}

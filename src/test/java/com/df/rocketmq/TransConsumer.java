package com.df.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;

/**
 * @author hanyli
 * @date 2021/3/9
 */
public class TransConsumer {
    public static void main(String[] args) throws Exception {
        /*DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer");
        consumer.setNamesrvAddr("192.168.138.128:9876");
        consumer.subscribe("TransactionTopic", "*");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {

                System.out.println("message: " + new String(list.get(0).getBody())+list.get(0).getReconsumeTimes());
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        System.out.println("consumer start");*/
        Integer i = new Integer(222);
        add(i);
        String s = new String("8878");
        a(s);
        System.out.println(s);
        System.out.println(i.intValue());
    }

    private static void a(String s) {
        s += "khfshk";
    }

    private static void add(Integer i) {
        i = new Integer(10);
        i++;
    }
}

package com.df.thread.base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hanyli
 * @date 2020/3/11
 */
class ReadThread {
    private static final ScheduledExecutorService executor = new
            ScheduledThreadPoolExecutor(1, Executors.defaultThreadFactory());
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
// 新建⼀个固定延迟时间的计划任务
        executor.scheduleWithFixedDelay(() -> {
            if (haveMsgAtCurrentTime()) {
                System.out.println(df.format(new Date()));
                System.out.println("⼤家注意了，我要发消息了");
            }
        }, 1, 1, TimeUnit.SECONDS);
        executor.shutdown();
    }

    public static boolean haveMsgAtCurrentTime() {
//查询数据库，有没有当前时间需要发送的消息
//这⾥省略实现，直接返回true
        return true;
    }
}

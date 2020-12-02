package com.df.sheJiMoShi.order;

/**
 * 命令模式
 * 将请求封装成一个对象  是可以用不同的请求对客户精心参数化
 * 对请求排队和记录请求日志  以及支持可撤销操作
 * @author hanyli
 * @date 2020/12/2
 */
public class Test {
    public static void main(String[] args) {
        Reciver chushi = new Reciver();
        Command chickenCommand = new ChickenCommand(chushi);
        Command zhutiCommand = new ZhutiCommand(chushi);
        Command zhurouCommand = new ZhurouCommand(chushi);
        Waiter waiter = new Waiter();

        waiter.setOrder(chickenCommand);
        waiter.setOrder(chickenCommand);
        waiter.setOrder(chickenCommand);

        waiter.setOrder(zhurouCommand);
        waiter.setOrder(zhurouCommand);

        waiter.setOrder(zhutiCommand);
        waiter.cancel(chickenCommand);
        waiter.notiy();
    }
}

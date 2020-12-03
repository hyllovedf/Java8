package com.df.sheJiMoShi.zhizelian;

/**
 * 职责链模式
 * 避免了发送者和接受者之间的耦合关系
 * 将多个对象连成一个链  请求沿着链传递 知道有一个对象处理这个请求
 * @author hanyli
 * @date 2020/12/3
 */
public class Test {
    public static void main(String[] args) {
        Request request1 = new Request("请假", 2);
        Request request2 = new Request("请假", 5);
        Request request3 = new Request("请假", 10);
        Request request4 = new Request("调薪", 200);
        Request request5 = new Request("调薪", 1000);
        Manager jingli = new Jingli("jingli");
        Manager zongjian = new Zongjian("zongjian");
        Manager laozong = new Laozong("laozong");
        jingli.setSuperior(zongjian);
        zongjian.setSuperior(laozong);

        jingli.deal(request1);
        jingli.deal(request2);
        jingli.deal(request3);
        jingli.deal(request4);
        jingli.deal(request5);
    }
}

package com.df.sheJiMoShi.zhizelian;

/**
 * @author hanyli
 * @date 2020/12/3
 */
public class Zongjian extends Manager {
    public Zongjian(String name) {
        super(name);
    }

    @Override
    public void deal(Request request) {
        if (("请假".equals(request.type) && request.num > 2 && request.num <= 6)||
        ("调薪".equals(request.type) && request.num <= 500)) {
            System.out.println("总监批准: "+request.toString());
        } else  {
            superior.deal(request);
        }
    }
}

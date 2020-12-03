package com.df.sheJiMoShi.zhongjie;

/**
 * @author hanyli
 * @date 2020/12/3
 */
public class USA extends Country {
    public USA(UnitedNations mediator) {
        super(mediator);
    }

    public void declare(String msg) {
        mediator.declare(msg,this);
    }

    public void getmsg(String msg) {
        System.out.println("美国获取消息: " + msg);
    }
}

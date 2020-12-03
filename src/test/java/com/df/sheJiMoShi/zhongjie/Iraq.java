package com.df.sheJiMoShi.zhongjie;

/**
 * @author hanyli
 * @date 2020/12/3
 */
public class Iraq extends Country {
    public Iraq(UnitedNations mediator) {
        super(mediator);
    }

    public void declare(String msg) {
        mediator.declare(msg,this);
    }

    public void getmsg(String msg) {
        System.out.println("伊拉克获得消息: "+msg);
    }
}

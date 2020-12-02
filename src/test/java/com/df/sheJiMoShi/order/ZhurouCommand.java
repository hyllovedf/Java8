package com.df.sheJiMoShi.order;

/**
 * @author hanyli
 * @date 2020/12/2
 */
public class ZhurouCommand extends Command {
    public ZhurouCommand(Reciver reciver) {
        super(reciver);
    }

    @Override
    void excuted() {
        reciver.zhurou();
    }
}

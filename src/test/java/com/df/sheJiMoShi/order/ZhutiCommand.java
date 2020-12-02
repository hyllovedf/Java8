package com.df.sheJiMoShi.order;

/**
 * @author hanyli
 * @date 2020/12/2
 */
public class ZhutiCommand extends Command {
    public ZhutiCommand(Reciver reciver) {
        super(reciver);
    }

    @Override
    void excuted() {
        reciver.zhuti();
    }
}

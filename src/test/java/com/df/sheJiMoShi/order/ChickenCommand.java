package com.df.sheJiMoShi.order;

/**
 * @author hanyli
 * @date 2020/12/2
 */
public class ChickenCommand extends Command {
    public ChickenCommand(Reciver reciver) {
        super(reciver);
    }

    @Override
    void excuted() {
        reciver.chicken();
    }
}

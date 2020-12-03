package com.df.sheJiMoShi.order;

/**
 * @author hanyli
 * @date 2020/12/2
 */
public class ZhutiCommand extends Command {
    public ZhutiCommand(Chef chef) {
        super(chef);
    }

    @Override
    void excuted() {
        chef.zhuti();
    }
}

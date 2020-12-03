package com.df.sheJiMoShi.order;

/**
 * @author hanyli
 * @date 2020/12/2
 */
public class ChickenCommand extends Command {
    public ChickenCommand(Chef chef) {
        super(chef);
    }

    @Override
    void excuted() {
        chef.chicken();
    }
}

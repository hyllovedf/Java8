package com.df.sheJiMoShi.order;

/**
 * @author hanyli
 * @date 2020/12/3
 */
public class FriedCommand extends Command {

    public FriedCommand(Chef chef) {
        super(chef);
    }

    @Override
    void excuted() {
        chef.fried();
    }
}

package com.df.sheJiMoShi.zhongjie;

/**
 * @author hanyli
 * @date 2020/12/3
 */
public abstract class Country {
    protected UnitedNations mediator;

    public Country(UnitedNations mediator) {
        this.mediator = mediator;
    }
}

package com.df.sheJiMoShi.order;

/**
 * @author hanyli
 * @date 2020/12/2
 */
public class BarbecueChef implements Chef {
    public void chicken() {
        System.out.println("烤  chicken");
    }

    public void zhurou() {
        System.out.println("烤  zhurou");
    }

    public void zhuti() {
        System.out.println("烤  zhuti");
    }

    @Override
    public void fried() {

    }
}

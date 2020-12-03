package com.df.sheJiMoShi.zhizelian;

/**
 * @author hanyli
 * @date 2020/12/3
 */
public class Laozong extends Manager {
    public Laozong(String name) {
        super(name);
    }

    @Override
    public void deal(Request request) {
        System.out.println("老总批准: "+request.toString());
    }
}

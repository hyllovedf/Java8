package com.df.sheJiMoShi.zhizelian;

/**
 * @author hanyli
 * @date 2020/12/3
 */
public abstract class Manager {
    protected String name;
    protected Manager superior;

    public Manager(String name) {
        this.name = name;
    }

    public void setSuperior(Manager superior) {
        this.superior = superior;
    }

    public abstract void deal(Request request);
}

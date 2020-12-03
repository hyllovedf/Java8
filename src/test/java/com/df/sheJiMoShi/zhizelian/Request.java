package com.df.sheJiMoShi.zhizelian;

/**
 * @author hanyli
 * @date 2020/12/3
 */
public class Request {
    protected String type;
    protected int num;

    public Request(String type, int num) {
        this.type = type;
        this.num = num;
    }

    @Override
    public String toString() {
        return type + "  " + num;
    }
}

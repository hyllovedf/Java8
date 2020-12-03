package com.df.sheJiMoShi.zhizelian;

/**
 * @author hanyli
 * @date 2020/12/3
 */
public class Jingli extends Manager {
    public Jingli(String name) {
        super(name);
    }

    @Override
    public void deal(Request request) {
        if ("请假".equals(request.type) && request.num <= 2) {
            System.out.println("经理批准: " + request.toString());
        } else {
            superior.deal(request);
        }
    }
}

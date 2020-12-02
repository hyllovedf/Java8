package com.df.sheJiMoShi.order;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hanyli
 * @date 2020/12/2
 */
public class Waiter {
    List<Command> list = new ArrayList<>();
    public void setOrder(Command command) {
        if (command instanceof ZhutiCommand) {
            System.out.println("没有zhuti");
        } else {
            list.add(command);
            System.out.println("增加菜单 "+command.toString());
        }

    }
    public void notiy() {
        for (Command command : list) {
            command.excuted();
        }
    }

    public void cancel(Command command) {
        list.remove(command);
    }
}

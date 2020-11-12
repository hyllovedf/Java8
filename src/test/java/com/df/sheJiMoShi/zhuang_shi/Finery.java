package com.df.sheJiMoShi.zhuang_shi;

import org.springframework.test.context.junit4.statements.ProfileValueChecker;

/**
 * @author hanyli
 * @date 2020/11/12
 */
public abstract class Finery implements Behavior{
    private Behavior person;

    public void decorate(Behavior person) {
        this.person = person;
    }
    public void show() {
        if (person != null) {
            person.show();
        }
    }
}

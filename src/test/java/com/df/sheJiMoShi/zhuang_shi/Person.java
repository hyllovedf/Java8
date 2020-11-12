package com.df.sheJiMoShi.zhuang_shi;

/**
 * @author hanyli
 * @date 2020/11/12
 */
public class Person implements Behavior {
    private String name;

    public Person(String name) {
        this.name = name;
    }
    public Person() {
    }

    public void show() {
        System.out.println(name);
    }
}

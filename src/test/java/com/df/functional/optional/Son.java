package com.df.functional.optional;

import org.assertj.core.api.OptionalAssert;

import java.util.Optional;

/**
 * create by hanyli 2019/11/21
 */
public class Son {
    private int age;
    private Toy toy;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Optional<Toy> getToy() {
        return Optional.ofNullable(toy);
    }

    public void setToy(Toy toy) {
        this.toy = toy;
    }
}

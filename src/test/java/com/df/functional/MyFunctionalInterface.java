package com.df.functional;

public interface MyFunctionalInterface {
    abstract  String test();

    default void te() {
        System.out.println("gjk");
    }
}

package com.df.functional.test;

public class Person {
    public Person() {
        System.out.println("person");
    }
    static {
        System.out.println("person static");
    }

    private int anInt = 9;
    {
        System.out.println("person single"+anInt);
    }
}

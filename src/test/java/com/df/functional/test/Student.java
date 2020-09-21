package com.df.functional.test;

/**
 * @author hanyli
 * @date 2020/4/17
 */
public class Student extends Person {
    public Student() {
        System.out.println("student");
    }
    static {
        System.out.println("student static");
    }
    {
        System.out.println("student single");
    }
}

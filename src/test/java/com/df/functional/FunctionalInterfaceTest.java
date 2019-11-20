package com.df.functional;

import com.df.functional.MyFunctionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * create by hanyli 2019/11/18
 */
public class FunctionalInterfaceTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Supplier aNew = FunctionalInterfaceTest::new;
        test(()-> {
            return "df";
        });
    }

    public static void test(MyFunctionalInterface myFunctionalInterface) {

        myFunctionalInterface.te();
        String test = myFunctionalInterface.test();
        System.out.println(test);
    }
}

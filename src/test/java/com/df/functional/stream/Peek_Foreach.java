package com.df.functional.stream;

import java.util.List;

/**
 * create by hanyli 2019/11/27
 */
public class Peek_Foreach {
    public static void main(String[] args) {
        List<Dish> menu = StreamApi.menu;

//        list.forEach(li -> li.setName("df"));
        System.out.println(menu);
//        menu = menu.stream().filter(li -> li.getCalories() > 300).peek(li -> li.setName("df")).collect(Collectors.toList());
        menu.stream().filter(li -> li.getCalories() > 300).forEach(li -> li.setName("df"));
        System.out.println(menu);
    }
}

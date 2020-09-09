package com.df.functional.stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * create by hanyli 2019/11/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamApi {

    public static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 800, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", false, 400, Dish.Type.OTHER),
            new Dish("rice", false, 350, Dish.Type.OTHER),
            new Dish("season fruit", false, 120, Dish.Type.OTHER),
            new Dish("pizza", false, 350, Dish.Type.OTHER),
            new Dish("prawns", false, 350, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

    @Test
    public void filter() {
        //筛选素食
        List<Dish> vegetarians = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
        System.out.println(vegetarians);
    }

    public void distinct() {
        //输出所有的偶数且不重复
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void limit() {
        //筛选出热量大于300的三道菜
        List<Dish> collect = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void skip() {
        //筛选出热量大于300的跳过前三道菜
        List<Dish> collect = menu.stream().filter(dish -> dish.getCalories() > 300).skip(3).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void map() {
        //获取菜名列表
        List<String> names = menu.stream().map(Dish::getName).collect(Collectors.toList());
        System.out.println(names);
    }

    @Test
    public void flatMap() {
        List<String> words = Arrays.asList("Hello", "World");
        List<String> collect = words.stream().map(word -> word.split(""))
                .flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void match() {
        //是否有素食
        Stream<Dish> stream = menu.stream();
        boolean b = stream.anyMatch(dish -> dish.getCalories() > 200);

        //是否都是素食
        boolean b1 = stream.allMatch(Dish::isVegetarian);
        //是否没有素食
        boolean b2 = stream.noneMatch(Dish::isVegetarian);
        //获取第一个
        Optional<Dish> first = stream.findFirst();
        //获取任意一个
        Optional<Dish> any = stream.findAny();
    }
    @Test
    public void collect() {
        List<Dish> collect7 = menu.stream().filter(m -> {
            if (m.getCalories() == 400) {
                m.setName("0909909");
            }
            return m.getCalories() >= 400;
        }).collect(toList());
        System.out.println(collect7);

        List<Integer> collect6 = menu.stream().map(Dish::getCalories).distinct().collect(toList());
        System.out.println(collect6);
        System.out.println((String)null);
        List<String> list = Arrays.asList("hello", "world","happy");
        //=======连接字符串joining=======
        System.out.println("=======连接字符串joining=======");
        String none = list.stream().collect(Collectors.joining());
        System.out.println(none);//helloworldhappy
        String one = list.stream().collect(Collectors.joining(","));
        System.out.println(one);//hello,world,happy
        String three = list.stream().collect(Collectors.joining(",","-",".jpg"));
        System.out.println(three);//-hello,world,happy.jpg

        //========分组groupingBy======
        System.out.println("========分组groupingBy======");
        //一个参数
        Map<Dish.Type, List<Dish>> oneMap = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(oneMap);//{M`EAT=[pork, beef, chicken], FISH=[prawns, salmon], OTHER=[french fries, rice, season fruit, pizza]}

        //两个参数
        Map<Dish.Type, Map<String, List<Dish>>> twoMap = menu.stream()
                .collect(groupingBy(Dish::getType, groupingBy(dish -> {
            if (dish.getCalories() <= 400) {
                return "low";
            }
            return "high";
        })));
        System.out.println(twoMap);//{MEAT={high=[pork, beef], low=[chicken]}, FISH={high=[salmon], low=[prawns]}, OTHER={high=[french fries, pizza], low=[rice, season fruit]}}

        Map<Dish.Type, Long> collect = menu.stream().collect(groupingBy(Dish::getType, counting()));
        System.out.println(collect);//{MEAT=3, FISH=2, OTHER=4}

        Map<Dish.Type, Set<String>> collect1 = menu.stream().collect(groupingBy(Dish::getType, mapping(dish -> {
            return dish.getCalories() < 400 ? "low" : "high";
        }, toSet())));
        System.out.println(collect1);

        System.out.println("=======分区partitioningBy====");
        Map<Boolean, List<Dish>> partitioningBy = menu.stream().collect(partitioningBy(Dish::isVegetarian));
        System.out.println(partitioningBy);
        Map<Boolean, List<Dish>> collect5 = menu.stream().collect(groupingBy(Dish::isVegetarian));
        System.out.println(collect5);

        System.out.println("=======mapping=======");
        Set<Dish.Type> mapping = menu.stream().map(Dish::getType).collect(toSet());
        ArrayList<Dish.Type> collect3 = menu.stream().map(Dish::getType).collect(toCollection(ArrayList::new));
        System.out.println(mapping);

        //collectingAndThen
        Dish collect2 = menu.stream().collect(collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get));
        Optional<Dish> collect4 = menu.stream().collect(maxBy(Comparator.comparingInt(Dish::getCalories)));

    }


}

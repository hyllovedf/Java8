package com.df.functional.optional;

import com.df.functional.stream.Dish;

import java.util.Optional;
import java.util.Properties;
import java.util.stream.IntStream;

/**
 * create by hanyli 2019/11/21
 */
public class OptionalTest {
    public static void main(String[] args)  {
        Properties properties = new Properties();
        properties.setProperty("a", "23");
        properties.setProperty("b", "-5");
        properties.setProperty("c", "g");

        System.out.println(readTime(properties, "c"));
        //ifPresent
        Optional<Integer> integer = Optional.of(10);
        integer.ifPresent(i -> System.out.println("值为： " + i));
        Optional<Object> empty = Optional.empty();
        empty.ifPresent(i -> System.out.println("值为： " + i));

        //map  flatMap filter
        Optional<Properties> optional = Optional.of(properties);
        Optional<String> a = optional.map(pr -> pr.getProperty("a"));

        Son son = new Son();
        Optional<Son> optionalSon = Optional.of(son);
        String name = optionalSon.flatMap(Son::getToy)
                .map(Toy::getProducer)
                .map(Producer::getName).orElse("df");
//        optionalSon.flatMap(Son::getToy).map(Toy::getProducer).ifPresent(Producer::getName);
        System.out.println(name);

        //orElse  orElseGet  orElseThrow
        Integer integer1 = optionalSon.filter(s->s.getAge()>10).map(Son::getAge)
                .orElseGet(() -> IntStream.rangeClosed(1, 10).reduce(0, Integer::sum));
        Integer orElse = optionalSon.filter(s -> s.getAge() > 10).map(Son::getAge)
                .orElse(10);
        Integer integer2 = optionalSon.filter(s -> s.getAge() > 10).map(Son::getAge)
                .orElseThrow(() -> new RuntimeException("没有age"));
        System.out.println(integer2);
    }


    private static int readTime(Properties properties, String name) {
        return Optional.ofNullable(properties.getProperty(name))
                .flatMap(OptionalUtil::stringToInt)
                .filter(integer -> integer > 0)
                .orElse(0);


    }
}

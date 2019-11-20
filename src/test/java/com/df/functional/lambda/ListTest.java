package com.df.functional.lambda;

import java.util.*;
import java.util.List;
import java.util.function.Predicate;

/**
 * create by hanyli 2019/11/18
 */
public class ListTest {
    public static void main(String[] args) {

        List<Dog> dogs = Arrays.asList(
                new Dog(2, 16, "red"),
                new Dog(4, 15, "green"),
                new Dog(3, 17, "red")
        );
        Comparator<Dog> weightReverse = Comparator.comparing(Dog::getWeight).reversed();
        dogs.sort(Comparator.comparing(Dog::getColor).thenComparing(weightReverse));
        System.out.println(dogs);
        Predicate<Dog> predicate = (dog) -> dog.getAge() > 3;
        Predicate<Dog> negate = predicate.negate();

        dogs.stream().filter(dog -> {
            return dog.getAge() > 3 || dog.getWeight() > 15;
        });

    }
}

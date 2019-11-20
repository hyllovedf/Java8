package com.df.functional.lambda;

/**
 * create by hanyli 2019/11/18
 */
public class Dog {
    private int age;
    private int weight;
    private String color;

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

    public Dog(int age, int weight, String color) {
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

package com.df.functional.stream;

/**
 * create by hanyli 2019/11/19
 */
public class Dish {
    private  String name;
    private  boolean vegetarian;
    private  int calories;
    private  Type type;

    public Dish() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum Type {MEAT, FISH, OTHER}
}

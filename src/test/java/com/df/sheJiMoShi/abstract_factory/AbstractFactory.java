package com.df.sheJiMoShi.abstract_factory;

/**
 * @author hanyli
 * @date 2020/11/25
 */
public abstract class AbstractFactory {
    public abstract Shape getShape(String shape);
    public abstract Color getColor(String color);
}

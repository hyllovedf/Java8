package com.df.sheJiMoShi.abstract_factory;

/**
 * @author hanyli
 * @date 2020/11/25
 */
public class FactoryProducer {
    public static AbstractFactory createFactory(String type) {
        switch (type) {
            case "shape":
                return new ShapeFactory();
            case "color":
                return new ColorFactory();
            default:
                return null;
        }
    }
}

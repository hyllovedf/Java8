package com.df.sheJiMoShi.abstract_factory;

/**
 * @author hanyli
 * @date 2020/11/25
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shape) {
        return null;
    }

    @Override
    public Color getColor(String color) {
        switch (color) {
            case "red":
                return new Red();
            case "blue":
                return new Blue();
            default:
                return null;
        }
    }
}

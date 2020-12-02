package com.df.sheJiMoShi.abstract_factory;

/**
 * @author hanyli
 * @date 2020/11/25
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shape) {
        switch (shape) {
            case "rectangle":
                return new Rectangle();
            case "round":
                return new Round();
            default:
                return null;
        }
    }

    @Deprecated
    @Override
    public Color getColor(String color) {
        return null;
    }
}

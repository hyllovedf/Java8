package com.df.functional.future;

/**
 * create by hanyli 2019/11/29
 */
public class Discount {
    public enum Code {
        NONE(0),
        SILVER(5),
        GOLD(10),
        PLATINUM(15),
        DIAMOND(20);

        private int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }
    public static String applyDiscount(Quote quote) {
        return quote.getName() + " price is " +
                Discount.apply(quote.getPrice(),
                        quote.getCode());
    }
    private static double apply(double price, Code code) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return (price * (100 - code.percentage) / 100);
    }
}

package com.df.functional.future;

/**
 * create by hanyli 2019/11/29
 */
public class Quote {
    private String name;
    private double price;
    private Discount.Code code;

    public Quote(String name, double price, Discount.Code code) {
        this.name = name;
        this.price = price;
        this.code = code;
    }

    public static Quote parse(String s) {
        String[] split = s.split(":");
        String shopName = split[0];
        double price = Double.parseDouble(split[1]);
        Discount.Code discountCode = Discount.Code.valueOf(split[2]);
        return new Quote(shopName, price, discountCode);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Discount.Code getCode() {
        return code;
    }

    public void setCode(Discount.Code code) {
        this.code = code;
    }
}

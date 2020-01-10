package com.df.functional.future;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;

/**
 * create by hanyli 2019/11/28
 */
public class Shop {
    private String name;
    private double price;

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice(String product) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Random random = new Random();
        return random.nextDouble() * name.charAt(0) + name.charAt(1);
    }
    public String getPriceStr(String product) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Random random = new Random();
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        double price = random.nextDouble() * name.charAt(0) + name.charAt(1);
        return String.format("%s:%.2f:%s", name, price, code);
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

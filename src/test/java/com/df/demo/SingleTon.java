package com.df.demo;

/**
 * @author hanyli
 * @date 2020/7/30
 */
public class SingleTon {
    private SingleTon() {

    }
    private volatile static SingleTon singleTon = null;
    public static SingleTon getInstance() {
        if (singleTon == null) {
            synchronized (SingleTon.class) {
                if (singleTon == null) {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }

}

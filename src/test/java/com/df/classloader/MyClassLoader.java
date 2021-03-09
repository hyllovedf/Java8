package com.df.classloader;

import com.df.functional.test.Person;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author hanyli
 * @date 2021/2/26
 */
public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = new byte[0];
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\work\\" + name.replaceAll("\\.","/") + ".class");
            data = new byte[fileInputStream.available()];
            fileInputStream.read(data);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defineClass(name, data, 0, data.length);
    }

    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> car = myClassLoader.loadClass("com.df.classloader.Car");
        Object o = car.newInstance();
        ClassLoader classLoader = car.getClassLoader();
        System.out.println(classLoader);
    }
}

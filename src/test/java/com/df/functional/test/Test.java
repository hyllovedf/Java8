package com.df.functional.test;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * create by hanyli 2019/12/10
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                set.add(getNo());
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(set.size());


 /* // 设置类成员属性
        HashMap propertyMap = new HashMap();

        propertyMap.put("id", Class.forName("java.lang.Integer"));

        propertyMap.put("name", Date.class);

        propertyMap.put("address", Class.forName("java.lang.String"));

        // 生成动态 Bean
        Bean bean = new Bean(propertyMap);

        // 给 Bean 设置值
        bean.setValue("id", new Integer(123));

        bean.setValue("name", "454");

        bean.setValue("address", "789");


        // 从 Bean 中获取值，当然了获得值的类型是 Object

        System.out.println("  >> id      = " + bean.getValue("id"));

        System.out.println("  >> name    = " + bean.getValue("name"));

        System.out.println("  >> address = " + bean.getValue("address"));

        // 获得bean的实体
        Object object = bean.getObject();

        // 通过反射查看所有方法名
        Class clazz = object.getClass();

        Method[] methods = clazz.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].getName());
        }*/
    }

    private static String getNo() {
        String orderNo = "";
        UUID uuid = UUID.randomUUID();
        String sdf = new SimpleDateFormat("yyyyMMddHHMMSS").format(new Date());
        orderNo = uuid.toString().substring(0, 8);
        orderNo = orderNo + sdf;
        return orderNo;
    }


}

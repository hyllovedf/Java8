package com.df.functional.test;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * create by hanyli 2019/12/10
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        String df = "fffsfs";
        String trim = "fsfsf";
        String s = StringUtils.substringBefore(df, trim);
        String s1 = StringUtils.substringBeforeLast(df, "f");
        System.out.println(s1);
        System.out.println(s);

        System.out.println(String.format("%s,%s", 1, 2));

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


        Map<Integer, String> map = new HashMap<>();
        map.put(2, "df");
        String s2 = map.get(1);
        String orDefault = map.getOrDefault(1, "");
        System.out.println(map.getOrDefault(1,""));

        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setMaximumFractionDigits(2);
        String format = decimalFormat.format(Double.parseDouble("12.8989"));
        System.out.println(format);

    }

}

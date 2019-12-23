package com.df.functional.util;

import com.alibaba.excel.EasyExcelFactory;
import com.df.functional.easyexcel.entity.DemoData;
import com.df.functional.easyexcel.listener.BaseListener;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * create by hanyli 2019/12/4
 */
public class ExcelUtil {

    public static void main(String[] args) throws Exception{
        String filename = "D:\\ideawork\\easyexcel-master\\src\\test\\resources\\demo\\demo.xlsx";

        List<Object> sheet1 = read(filename, DemoData.class, "Sheet1");
        System.out.println(sheet1);
    }

    public static List<Object> read(String filename,Class c, String sheetName) {
        BaseListener baseListener = new BaseListener();
        EasyExcelFactory.read(filename,c, baseListener).sheet(sheetName).doRead();
        return baseListener.list;
    }
    public static void readAll(String filename,Class c) throws IllegalAccessException, InstantiationException {

        BaseListener baseListener = new BaseListener();
        EasyExcelFactory.read(filename,c,baseListener).doReadAll();
        List<Object> list = baseListener.list;
        List<String> strings = list.stream().map(li -> {
            DemoData demoData = (DemoData) li;
            return demoData.getString();
        }).collect(Collectors.toList());
        System.out.println(strings);

        Map<String, List<Object>> map = baseListener.map;
        System.out.println(map);
    }
}

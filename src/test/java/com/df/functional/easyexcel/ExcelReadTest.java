package com.df.functional.easyexcel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.df.functional.easyexcel.entity.ConverterData;
import com.df.functional.easyexcel.entity.DemoData;
import com.df.functional.easyexcel.entity.RptFormula;
import com.df.functional.easyexcel.listener.*;
import com.sun.javafx.logging.JFRInputEvent;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * create by hanyli 2019/12/3
 */
public class ExcelReadTest {
    public static void main(String[] args) throws FileNotFoundException {
//        String filename = "D:\\ideawork\\easyexcel-master\\src\\test\\resources\\demo\\demo.xlsx";
        String filename = "D:\\work\\(1127005002)北戴河燕山疗养院.xls";
        singleRead(filename);
//        readAll(filename);
//        converterRead(filename);
//        noModelRead(filename);
        long start = System.nanoTime();
//        rptFormulaRead(filename);
        System.out.println("time: "+(System.nanoTime() - start) / 1000000);
    }

    private static void readAll(String filename) {
        EasyExcelFactory.read(filename, DemoData.class, new DemoDataListListener()).doReadAll();
    }

    private static void singleRead(String filename) throws FileNotFoundException {
//        EasyExcelFactory.read(filename, DemoData.class, new DemoDataListListener()).sheet().doRead();
//        EasyExcelFactory.read(filename, new DemoDataListListener()).sheet().headRowNumber(2).doRead();

        NoModleDataListener listener = new NoModleDataListener();
        EasyExcelFactory.read(new FileInputStream(filename), listener).headRowNumber(0)
                .useDefaultListener(false).doReadAll();


//        List<Object> objects = EasyExcelFactory.read(filename).sheet().doReadSync();
//        for (Object object : objects) {
//            System.out.println(object);
//        }

//
//        ReadSheet readSheet = EasyExcelFactory.readSheet(0).build();
//        excelReader.read(readSheet);
//        excelReader.finish();
    }

    @Test
    public void converterRead() {
        String filename = "D:\\ideawork\\easyexcel-master\\src\\test\\resources\\demo\\demo.xlsx";
        EasyExcelFactory.read(filename,ConverterData.class, new ConvertDemoDataListener())
                .registerConverter(new CustomStringStringConverter())
                .sheet().doRead();
    }

    public static void noModelRead(String filename) {
        EasyExcelFactory.read(filename, new NoModleDataListener())
                .sheet().doRead();
    }

    public static void rptFormulaRead(String filename) {
        EasyExcelFactory.read(filename)
                .doReadAll();
    }



}

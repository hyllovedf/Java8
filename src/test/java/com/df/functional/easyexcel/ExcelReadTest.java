package com.df.functional.easyexcel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.analysis.ExcelReadExecutor;
import com.alibaba.excel.cache.MapCache;
import com.alibaba.excel.cache.selector.SimpleReadCacheSelector;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.df.functional.easyexcel.entity.*;
import com.df.functional.easyexcel.listener.*;
import com.df.functional.util.ExcelUtil;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

/**
 * create by hanyli 2019/12/3
 */
public class ExcelReadTest {
    public static void main(String[] args) throws FileNotFoundException {

//        String filenamie = "D:\\ideawork\\easyexcel-master\\src\\test\\resources\\demo\\demo.xlsx";
//        String filename = "D:\\work\\(1127005002)北戴河燕山疗养院.xls";
//        String filename = "D:\\work\\df1.xlsx";
        String filename = "D:\\work\\simpleWrite.xls";
//        String filename = "D:\\水质分析成果台账模板.xlsx";
//        String filename =
//                "C:\\Users\\Administrator\\Downloads\\[999020001]湖南管局本级 (1).xlsx";

//        String filename = "D:\\work\\export.xlsx";
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
//        NoModleDataListener listener = new NoModleDataListener();
////        ZipSecureFile.setMinInflateRatio(-1.0D);
//        EasyExcelFactory.read(filename, listener)
//                .headRowNumber(0)
//                .readCache(new MapCache())
//                .autoTrim(false).ignoreEmptyRow(true)
//                .useDefaultListener(false).doReadAll();
//        ExcelReader reader = EasyExcelFactory.read(filename, listener).build();
//        ExcelReadExecutor excelReadExecutor = reader.excelExecutor();
//        List<ReadSheet> readSheets = excelReadExecutor.sheetList();
        BaseListener demoDataListListener = new BaseListener();
        /*ExcelReader excelReader = new ExcelReader(new FileInputStream(filename), ExcelTypeEnum.XLSX, null, demoDataListListener);
        excelReader.read();
        List<Object> list = demoDataListListener.getList();
        excelReader.finish();
        System.out.println(list.size());*/

        EasyExcelFactory.read(filename, DemoData2.class, new DataListListener()).sheet(1).doRead();



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
    @Test
    public void noModelRead() {
        String filename = "D:\\work\\simpleWrite.xlsx";
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "df");
        EasyExcelFactory.read(filename,new NoModleDataListener()).useDefaultListener(false)
                .sheet().doRead();
    }

    public static void rptFormulaRead(String filename) {
        EasyExcelFactory.read(filename)
                .doReadAll();
    }



}

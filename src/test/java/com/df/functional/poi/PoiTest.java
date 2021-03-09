package com.df.functional.poi;

import com.df.functional.easyexcel.entity.DemoData;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * create by hanyli 2019/12/4
 */
public class PoiTest {
    private final static String[] sheetTitle = {"string", "data", "double"};

    private final static int[] colWidths = {25 * 256, 25 * 256, 12 * 256};

    private static List<DemoData> list = new ArrayList<>();

    static {
        for (int i = 0; i < 200000; i++) {
//            list.add(new DemoData("string: " + i, new Date(), 0.56, "ignore"));
        }
    }
    public static void main(String[] args) throws Exception {
//        writeTest();
//        readWrite();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        list.remove(new Integer(1));
        System.out.println(list);
    }

    public static void readWrite() throws Exception {
        long start = System.currentTimeMillis();
        InputStream inputStream = new FileInputStream("df.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        BaseReader baseReader = new BaseReader(workbook);
        List<DemoData> fmuList = baseReader.getFmuList();
        System.out.println(fmuList.size() + "--" + (System.currentTimeMillis() - start));
    }

    private static void writeTest() throws IOException {
        long start = System.currentTimeMillis();
        XSSFWorkbook workBook = new XSSFWorkbook();
        XSSFSheet sheet = workBook.createSheet("filename");
        createTitle(workBook, sheet);
        // 创建一个居中格式
        list.forEach((formula) -> {
            //对应表头内容
            String[] cellArr = {formula.getString(), formula.getDate().toString(), formula.getDoubleData().toString()};
            createRow(sheet, cellArr);
        });
        OutputStream outputStream = new FileOutputStream("df.xlsx");
        workBook.write(outputStream);
        outputStream.close();
        System.out.println(System.currentTimeMillis() - start);
    }

    /**
     * 生成标题
     *
     * @param sheet
     */
    private static void createTitle(XSSFWorkbook workBook, XSSFSheet sheet) {
        XSSFRow row = sheet.createRow(0);
//        //设置标题样式
//        XSSFCellStyle titleStyle = workBook.createCellStyle();
//        titleStyle.setAlignment(HorizontalAlignment.CENTER);
//        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
//        titleStyle.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
//        titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        XSSFFont font = workBook.createFont();
//        font.setBold(true);
//        font.setColor(IndexedColors.WHITE.getIndex());
//        titleStyle.setFont(font);
        //填充单元格数据
        XSSFCell cell = null;
        for (int i = 0; i < sheetTitle.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(sheetTitle[i]);
//            cell.setCellStyle(titleStyle);
            cell.setCellType(CellType.STRING);
            sheet.setColumnWidth(i, colWidths[i]);
        }
    }

    /**
     * 生成表行
     *
     * @param sheet
     * @param
     * @param
     */
    private static void createRow(XSSFSheet sheet, String[] cellArr) {
        XSSFRow row = sheet.createRow(sheet.getLastRowNum() + 1);
        XSSFCell cell = null;
        for (int i = 0; i < sheetTitle.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(cellArr[i]);
//            cell.setCellStyle(cellStyle);
        }
    }
}

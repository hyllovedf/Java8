package com.df.functional.poi;

import com.df.functional.easyexcel.entity.DemoData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * create by hanyli 2019/12/4
 */
public class BaseReader {
    protected Workbook workBook;

    protected int startRow = 1;

    public BaseReader(Workbook book){
        this.workBook = book;
    }

    /**
     * 获取Excel内的公式信息
     * @return
     */
    public List<DemoData> getFmuList(){
        int sheetNum = workBook.getNumberOfSheets();

        Sheet sheet;
        List<DemoData> fmuList,allFmuList = new ArrayList<>();
        for (int i = 0; i < sheetNum; i++) {
            sheet = workBook.getSheetAt(i);
            fmuList = readSheet(sheet);
            allFmuList.addAll(fmuList);
        }

        return allFmuList;
    }


    public List<String> getRptCodeList(){

        int sheetNum = workBook.getNumberOfSheets();

        Sheet sheet;
        String rptCode;
        List<String> codeList = new ArrayList<>();
        for (int i = 0; i < sheetNum; i++) {
            sheet = workBook.getSheetAt(i);
            for (int r = startRow; r < sheet.getLastRowNum(); r++) {
                rptCode = sheet.getRow(r).getCell(0).getStringCellValue();
                if (!codeList.contains(rptCode)) {
                    codeList.add(rptCode);
                }
            }
        }

        return codeList;
    }

    /**
     * 解析页签内容
     * @param sheet
     * @return
     */
    private List<DemoData> readSheet(Sheet sheet){
        List<DemoData> fmuList = new ArrayList<>();
        DemoData fmu= null;

        for (int r = startRow; r <= sheet.getLastRowNum(); r++) {
            fmu = createFmu(sheet.getRow(r));
            fmuList.add(fmu);
        }

        return fmuList;
    }

    /**
     * 取单元格内容
     * @param row
     * @param col
     * @return
     */
    protected String getCellStr(Row row, int col){
        Cell cell = row.getCell(col);
        if (cell==null) {
            return "";
        }

        String cellValue = "";
        switch (cell.getCellTypeEnum()){
            case STRING:{
                cellValue = cell.getStringCellValue();
                break;
            }
            case NUMERIC:{
                cellValue = String.valueOf((new Double(cell.getNumericCellValue())).intValue());
                break;
            }
            default:{
                cellValue = "";
            }
        }

        return cellValue;
    }


    public DemoData createFmu(Row row){
        DemoData demoData = new DemoData();
        demoData.setString(getCellStr(row,0));
//        demoData.setDate(new Date());
        demoData.setDoubleData(Double.parseDouble(getCellStr(row, 2)));
        return demoData;
    }
}

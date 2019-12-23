package com.df.functional.easyexcel.handler;

import com.alibaba.excel.write.handler.RowWriteHandler;
import com.alibaba.excel.write.handler.WorkbookWriteHandler;
import com.alibaba.excel.write.handler.WriteHandler;
import com.alibaba.excel.write.merge.LoopMergeStrategy;
import com.alibaba.excel.write.merge.OnceAbsoluteMergeStrategy;
import com.alibaba.excel.write.metadata.WriteWorkbook;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.Arrays;
import java.util.List;

/**
 * create by hanyli 2019/12/6
 */
public class MyHandler extends LoopMergeStrategy implements WorkbookWriteHandler {
    public MyHandler() {
        super(2,0);
    }

    public MyHandler(int eachRow, int columnIndex) {
        super(eachRow, columnIndex);
    }

    public MyHandler(int eachRow, int columnCount, int columnIndex) {
        super(eachRow, columnCount, columnIndex);
    }

    @Override
    public void beforeWorkbookCreate() {
        System.out.println("before");
    }

    @Override
    public void afterWorkbookCreate(WriteWorkbookHolder writeWorkbookHolder) {
        WriteWorkbook writeWorkbook = writeWorkbookHolder.getWriteWorkbook();

        writeWorkbook.setCustomWriteHandlerList(Arrays.asList(new OnceAbsoluteMergeStrategy(11,12,2,3)));
        List<WriteHandler> customWriteHandlerList = writeWorkbook.getCustomWriteHandlerList();
        writeWorkbookHolder.getCachedWorkbook().removeSheetAt(1);
    }

    @Override
    public void afterWorkbookDispose(WriteWorkbookHolder writeWorkbookHolder) {

        Workbook cachedWorkbook = writeWorkbookHolder.getCachedWorkbook();
        Workbook workbook = writeWorkbookHolder.getWorkbook();

//        cachedWorkbook.removeSheetAt(1);
        int numberOfSheets = cachedWorkbook.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {

            Sheet sheetAt = cachedWorkbook.getSheetAt(i);
            CellStyle cellStyle = cachedWorkbook.createCellStyle();

            sheetAt.getRow(2).getCell(2).setCellValue(73824836);
            sheetAt.getRow(1).getCell(1).setCellValue("dgsgsgsgs");
            Sheet sheet = workbook.getSheetAt(i);
            sheet.getRow(11).getCell(0).setCellValue("df");

        }

        System.out.println(cachedWorkbook.getNumberOfSheets());
    }
}

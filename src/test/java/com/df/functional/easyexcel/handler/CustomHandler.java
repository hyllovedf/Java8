package com.df.functional.easyexcel.handler;

import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.RowWriteHandler;
import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.alibaba.excel.write.handler.WorkbookWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;
import org.apache.poi.ss.usermodel.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * create by hanyli 2019/12/6
 */
public class CustomHandler implements WorkbookWriteHandler {
    private List<Row> rows = new ArrayList<>();
    @Override
    public void beforeWorkbookCreate() {

    }

    @Override
    public void afterWorkbookCreate(WriteWorkbookHolder writeWorkbookHolder) {
        Workbook cachedWorkbook = writeWorkbookHolder.getCachedWorkbook();
        Sheet sheetAt = cachedWorkbook.getSheetAt(0);
        Row row1 = sheetAt.getRow(0);
        Iterator<Cell> cellIterator = row1.cellIterator();
        cellIterator.hasNext();
//        Row row = sheetAt.createRow(1);
//        Cell cell = row.createCell(0);
//        CellStyle cellStyle = cell.getCellStyle();
//        cell.setCellValue("{.name}");
//        Cell cell1 = row.createCell(2);
//        cell1.setCellValue("{.age}");

//        sheetAt.removeRow(row);
    }

    @Override
    public void afterWorkbookDispose(WriteWorkbookHolder writeWorkbookHolder) {

    }
}

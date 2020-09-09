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
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        DataFormat dataFormat = cachedWorkbook.createDataFormat();
        Workbook workbook = writeWorkbookHolder.getWorkbook();
        DataFormat dataFormat1 = workbook.createDataFormat();
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat((short)4);
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
        Workbook workbook = writeWorkbookHolder.getWorkbook();
        Sheet sheetAt = workbook.getSheetAt(0);
        CellRangeAddress cellRangeAddress = new CellRangeAddress(30, 30, 0, 5);
        sheetAt.addMergedRegion(cellRangeAddress);
        CellStyle cellStyle = workbook.createCellStyle();
        String s = "lkh;fshf;ahf;hvhldv";
        RichTextString richTextString = workbook.getCreationHelper().createRichTextString(s);
        Font font = workbook.createFont();
        font.setColor(Font.COLOR_RED);
        richTextString.applyFont(0,5, font);
        richTextString.applyFont(5,s.length(), (short) 1);

        Row row = sheetAt.createRow(30);

        Cell cell = row.createCell(0);

        cell.setCellStyle(cellStyle);
        cell.setCellValue(richTextString);


    }
}

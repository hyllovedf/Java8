package com.df.functional.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.util.ConverterUtils;
import com.df.functional.easyexcel.entity.DemoData;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * create by hanyli 2019/12/3
 */
public class NoModleDataListener extends AnalysisEventListener<Map<Integer, CellData>> {

    private List<Map<Integer, CellData>> list = new ArrayList<>();
    private boolean aBoolean = true;
    public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context) {
        String sheetName = context.readSheetHolder().getSheetName();
        return;
    }
    public boolean hasNext(AnalysisContext context) {

        return aBoolean;
    }
    @SneakyThrows
    @Override
    public void invoke(Map<Integer, CellData> integerCellDataMap, AnalysisContext analysisContext) {
        ExcelTypeEnum excelType = analysisContext.readWorkbookHolder().getExcelType();
        list.add(integerCellDataMap);
        aBoolean = false;
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        aBoolean = true;
        System.out.println(list.size());
    }
}

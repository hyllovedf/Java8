package com.df.functional.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.util.ConverterUtils;
import com.df.functional.easyexcel.entity.DemoData;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Name;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * create by hanyli 2019/12/3
 */
public class NoModleDataListener extends AnalysisEventListener<Map<Integer, CellData>> {

    private List<Map<Integer, CellData>> list = new ArrayList<>();
    public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context) {
        String sheetName = context.readSheetHolder().getSheetName();
        Function<String, Map> stringIntegerFunction = (String s) -> {
            Map map = new HashMap();
            map.put(s, 1);
            return map;
        };
    }
    private boolean hasnext = true;
    @SneakyThrows
    @Override
    public void invoke(Map<Integer, CellData> integerCellDataMap, AnalysisContext analysisContext) {
        ExcelTypeEnum excelType = analysisContext.readWorkbookHolder().getExcelType();
        list.add(integerCellDataMap);
        /*if () {
        达到某个条件设置
            hasnext = false;
        }*/
    }

    @Override
    public boolean hasNext(AnalysisContext context) {
        return hasnext;
    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println(list.size());
        list.clear();
    }
}

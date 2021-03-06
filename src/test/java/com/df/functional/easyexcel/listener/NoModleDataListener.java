package com.df.functional.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.read.metadata.holder.ReadRowHolder;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.util.ConverterUtils;

import com.df.functional.easyexcel.entity.DemoData;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Name;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * create by hanyli 2019/12/3
 */
public class NoModleDataListener extends AnalysisEventListener<Map<Integer, CellData>> {

    private List<Map<Integer, CellData>> list = new ArrayList<>();
    public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context) {
        CellData<Object> objectCellData = new CellData<>();
        /*BigDecimal numberValue = headMap.get(2).getNumberValue();
        long l = numberValue.longValue();
        System.out.println(l);*/
        CellDataTypeEnum type = headMap.get(2).getType();
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
        long l = integerCellDataMap.get(2).getNumberValue().longValue();
        List<ReadSheet> readSheets = analysisContext.readSheetList();
        Set<Integer> hasReadSheet = analysisContext.readWorkbookHolder().getHasReadSheet();
        hasReadSheet.size();
        ExcelTypeEnum excelType = analysisContext.readWorkbookHolder().getExcelType();
        list.add(integerCellDataMap);
        if (list.size() == 2) {
            throw new RuntimeException();
        }
        /*if () {
        达到某个条件设置
            hasnext = false;
        }*/
    }

    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        throw new RuntimeException(exception);
    }

    @Override
    public boolean hasNext(AnalysisContext context) {
        return hasnext;
    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        Sheet currentSheet = analysisContext.getCurrentSheet();
        List<ReadSheet> readSheets = analysisContext.readSheetList();
        System.out.println(list.size());
        list.clear();
    }
}

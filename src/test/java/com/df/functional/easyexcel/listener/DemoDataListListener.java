package com.df.functional.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.read.metadata.ReadWorkbook;
import com.alibaba.excel.read.metadata.holder.ReadHolder;
import com.alibaba.excel.read.metadata.holder.ReadSheetHolder;
import com.alibaba.excel.read.metadata.holder.ReadWorkbookHolder;
import com.alibaba.excel.read.metadata.property.ExcelReadHeadProperty;
import com.df.functional.easyexcel.CommonException;
import com.df.functional.easyexcel.entity.DemoData;
import com.df.functional.easyexcel.entity.WaterAnalysisExcelDTO;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * create by hanyli 2019/12/3
 */
public class DemoDataListListener extends AnalysisEventListener<WaterAnalysisExcelDTO> {
    private List<WaterAnalysisExcelDTO> list = new ArrayList<>();
    private InputStream inputStream;


    @SneakyThrows
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
    }

    @Override
    public void invoke(WaterAnalysisExcelDTO demoData, AnalysisContext analysisContext) {
        ReadSheetHolder readSheetHolder = analysisContext.readSheetHolder();
        readSheetHolder.getSheetName();
        Integer rowIndex = analysisContext.readRowHolder().getRowIndex();

        list.add(demoData);
    }
//    @Override
//    public void onException(Exception exception, AnalysisContext context) throws Exception {
//        throw exception;
//    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        ReadWorkbook readWorkbook = analysisContext.readWorkbookHolder().getReadWorkbook();
        InputStream inputStream = readWorkbook.getInputStream();
        this.inputStream = inputStream;
        System.out.println(list);
    }

    public List<WaterAnalysisExcelDTO> getList() {
        return list;
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}

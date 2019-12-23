package com.df.functional.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.read.metadata.ReadWorkbook;
import com.alibaba.excel.read.metadata.holder.ReadHolder;
import com.alibaba.excel.read.metadata.holder.ReadSheetHolder;
import com.alibaba.excel.read.metadata.holder.ReadWorkbookHolder;
import com.alibaba.excel.read.metadata.property.ExcelReadHeadProperty;
import com.df.functional.easyexcel.entity.DemoData;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * create by hanyli 2019/12/3
 */
public class DemoDataListListener extends AnalysisEventListener<DemoData> {
    private List<DemoData> list = new ArrayList<>();
    private InputStream inputStream;
    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
        ReadSheetHolder readSheetHolder = analysisContext.readSheetHolder();
        readSheetHolder.getSheetName();
        Integer rowIndex = analysisContext.readRowHolder().getRowIndex();

        list.add(demoData);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        ReadWorkbook readWorkbook = analysisContext.readWorkbookHolder().getReadWorkbook();
        InputStream inputStream = readWorkbook.getInputStream();
        this.inputStream = inputStream;
        System.out.println(list);
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}

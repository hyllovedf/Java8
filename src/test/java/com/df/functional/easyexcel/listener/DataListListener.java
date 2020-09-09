package com.df.functional.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.ReadWorkbook;
import com.alibaba.excel.read.metadata.holder.ReadSheetHolder;
import com.df.functional.easyexcel.entity.DemoData;
import com.df.functional.easyexcel.entity.DemoData2;
import com.df.functional.easyexcel.entity.WaterAnalysisExcelDTO;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * create by hanyli 2019/12/3
 */
public class DataListListener extends AnalysisEventListener<DemoData2> {
    private List<WaterAnalysisExcelDTO> list = new ArrayList<>();
    private InputStream inputStream;


    @Override
    public void invoke(DemoData2 demoData, AnalysisContext analysisContext) {
        System.out.println(demoData);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}

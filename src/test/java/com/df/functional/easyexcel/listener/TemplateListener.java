package com.df.functional.easyexcel.listener;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.df.functional.easyexcel.entity.TemplateEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * create by hanyli 2019/12/5
 */
public class TemplateListener extends AnalysisEventListener<TemplateEntity> {
    public List<TemplateEntity> list = new ArrayList<>();
    public List<List<TemplateEntity>> totalList = new ArrayList<>();
    private static ExcelWriter excelWriter;
    private static WriteSheet writeSheet;
    private Future future;

//    static {
//        excelWriter = EasyExcelFactory.write("lll.xlsx", TemplateEntity.class).build();
//        writeSheet = EasyExcelFactory.writerSheet().build();
//
//    }

    @Override
    public void invoke(TemplateEntity templateEntity, AnalysisContext analysisContext) {
        analysisContext.readSheetHolder().getApproximateTotalRowNumber();

        list.add(templateEntity);
//        if (list.size() > 10000) {
//            excelWriter.write(list, writeSheet);
//            list.clear();
//        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
//        if (!list.isEmpty()) {
//            excelWriter.write(list, writeSheet);
//        }
//        excelWriter.finish();
    }

    public List<TemplateEntity> getList() {
        return list;
    }
}

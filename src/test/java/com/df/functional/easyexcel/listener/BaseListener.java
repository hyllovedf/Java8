package com.df.functional.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.df.functional.easyexcel.entity.DemoData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by hanyli 2019/12/4
 */
public class BaseListener extends AnalysisEventListener<Object> {
    public Map<String, List<Object>> map = new HashMap<>();
    public List<Object> list = new ArrayList();
    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        list.add(o);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        String sheetName = analysisContext.readSheetHolder().getSheetName();
        map.put(sheetName, list);
    }
}

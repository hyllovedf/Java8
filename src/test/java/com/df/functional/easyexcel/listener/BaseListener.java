package com.df.functional.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.df.functional.easyexcel.entity.DemoData;

import java.util.*;

/**
 * create by hanyli 2019/12/4
 */
public class BaseListener extends AnalysisEventListener<Object> {
    public Map<String, List<Object>> map = new HashMap<>();
    public List<Object> list = new ArrayList();
    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        Set<Integer> hasReadSheet = analysisContext.readWorkbookHolder().getHasReadSheet();
        hasReadSheet.size();
        list.add(o);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        String sheetName = analysisContext.readSheetHolder().getSheetName();
        map.put(sheetName, list);
    }

    public List<Object> getList() {
        return list;
    }
}

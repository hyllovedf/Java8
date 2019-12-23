package com.df.functional.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.df.functional.easyexcel.entity.RptFormula;

import java.util.ArrayList;
import java.util.List;

/**
 * create by hanyli 2019/12/3
 */
public class RptFormulaListener extends AnalysisEventListener<RptFormula> {
    List<RptFormula> list = new ArrayList<>();
    @Override
    public void invoke(RptFormula rptFormula, AnalysisContext analysisContext) {
        list.add(rptFormula);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("size: "+list.size());
    }
}

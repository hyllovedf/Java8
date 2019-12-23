package com.df.functional.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.util.DateUtils;
import com.df.functional.easyexcel.entity.ConverterData;
import com.df.functional.easyexcel.entity.DemoData;
import org.apache.poi.ss.usermodel.DateUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * create by hanyli 2019/12/3
 */
public class ConvertDemoDataListener extends AnalysisEventListener<ConverterData> {

    @Override
    public void invoke(ConverterData integerStringMap, AnalysisContext analysisContext) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}

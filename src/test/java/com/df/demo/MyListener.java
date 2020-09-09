package com.df.demo;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author hanyli
 * @date 2020/4/19
 */
public class MyListener extends AnalysisEventListener<Record> {
    private Map<String, Map<String,List<Record>>> map = new HashMap<>();
    private Map<String,List<Record>> recordMap = new HashMap<>();

    public Map<String, Map<String, List<Record>>> getMap() {
        return map;
    }

    @SneakyThrows
    @Override
    public void invoke(Record data, AnalysisContext context) {
        if (recordMap.containsKey(data.getMonth())) {
            List list = recordMap.get(data.getMonth());
            list.add(data);
        } else {
            List<Record> records = new ArrayList<>();
            records.add(data);
            recordMap.put(data.getMonth(), records);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        String code = context.readSheetHolder().getSheetName().substring(0, 5);
        Map<String, List<Record>> newMap = new HashMap<>(recordMap);
        map.put(code, newMap);
        recordMap.clear();
    }
}

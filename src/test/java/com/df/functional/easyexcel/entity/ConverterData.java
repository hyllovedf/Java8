package com.df.functional.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.converters.string.StringImageConverter;
import com.df.functional.easyexcel.listener.CustomStringStringConverter;
import lombok.Data;

import java.util.Date;

/**
 * create by hanyli 2019/12/3
 */
@Data
public class ConverterData {
    /**
     * 我自定义 转换器，不管数据库传过来什么 。我给他加上“自定义：”
     */
    @ExcelProperty(converter = StringImageConverter.class)
    private String string;

    /**
     * 这里用string 去接日期才能格式化。我想接收年月日格式
     */
//    @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
    private Date date;
    /**
     * 我想接收百分比的数字
     */
//    @NumberFormat("#.##%")
    private String doubleData;
    private String string1;
}

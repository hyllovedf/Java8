package com.df.functional.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.*;
import com.alibaba.excel.converters.string.StringImageConverter;
import com.df.functional.easyexcel.handler.CustomStringImageConverter;
import com.df.functional.easyexcel.listener.CustomStringStringConverter;
import lombok.*;
import org.apache.poi.ss.usermodel.BorderStyle;

import java.util.Date;

/**
 * create by hanyli 2019/12/3
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
//@ContentRowHeight(15)
//@HeadRowHeight(25)
@ColumnWidth(15)
@ExcelIgnoreUnannotated
@ContentStyle(borderLeft = BorderStyle.THIN,borderBottom = BorderStyle.THIN,borderRight = BorderStyle.THIN)
@HeadStyle(borderLeft = BorderStyle.THIN,borderBottom = BorderStyle.THIN,borderRight = BorderStyle.THIN)
public class DemoData {

//    @ExcelProperty(value = "字符串")
    private String string;
    @ColumnWidth(50)
    @ExcelProperty(value = "日期",index = 1)
    private Date date;
    @NumberFormat
    @ExcelProperty(value = "数字",converter = CustomStringStringConverter.class,index = 0)
    private Double doubleData;
    @ExcelIgnore
    private String ignore;

}


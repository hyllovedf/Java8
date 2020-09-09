package com.df.functional.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.df.functional.easyexcel.listener.CustomStringStringConverter;
import lombok.*;

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
public class DemoData2 {

//    @ExcelProperty(value = "字符串")
    private String string;
    @ColumnWidth(50)
//    @ExcelProperty("日期")
    @DateTimeFormat("yyyy-MM-dd")
    private String date;
    @NumberFormat
    @ExcelProperty(value = "数字")
    private Double doubleData;
    @ExcelIgnore
    private String ignore;

}


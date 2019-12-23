package com.df.functional.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * create by hanyli 2019/12/3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@ContentRowHeight(15)
//@HeadRowHeight(25)
@ColumnWidth(15)
public class DemoData {

    private String string;
    @ColumnWidth(50)
    private Date date;
    @NumberFormat
    private Double doubleData;
    @ExcelIgnore
    private String ignore;

}


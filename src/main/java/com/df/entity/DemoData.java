package com.df.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
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
public class DemoData {

    @ExcelProperty("字符串")
    private String string;
    @ColumnWidth(50)
    @ExcelProperty("日期")
    private Date date;
    @NumberFormat
    @ExcelProperty("数字")
    private Double doubleData;
    @ExcelIgnore
    private String ignore;

}


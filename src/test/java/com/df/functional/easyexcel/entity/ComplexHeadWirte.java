package com.df.functional.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * create by hanyli 2019/12/4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplexHeadWirte {
    @ExcelProperty({"主标题","fu","string"})
    private String string;
    @ExcelProperty({"主标题","fu","date"})
    private Date date;
    @ExcelProperty({"doubleData"})
    private Double doubleData;
}

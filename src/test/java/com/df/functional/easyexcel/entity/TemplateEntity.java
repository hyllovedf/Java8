package com.df.functional.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * create by hanyli 2019/12/5
 */
@Data
public class TemplateEntity {
    @ExcelIgnore
    private String id;
//    @ExcelProperty(value = "资产名称")
    private String s;
//    @ExcelProperty(value = "行次")
    private String s1;
//    @ExcelProperty(value = "资产编号")
    private String s2;
//    @ExcelProperty(value = "资产分类代码")
    private String s3;
//    @ExcelProperty(value = "资产分类名称")
    private String s4;
//    @ExcelProperty(value = "品牌")
    private String s5;
//    @ExcelProperty(value = "数量")
    private String s6;
//    @ExcelProperty(value = "取得方式")
    private String s7;
//    @ExcelProperty(value = "取得日期")
    private String s8;
//    @ExcelProperty(value = "采购组织形式")
    private String s9;
//    @ExcelProperty(value = "原值")
    private String s10;
//    @ExcelProperty(value = {"资金来源","财政拨款"})
    private String s11;
//    @ExcelProperty(value = {"资金来源","事业收入"})
    private String s12;
//    @ExcelProperty(value = {"资金来源","其中：预算外资金"})
    private String s13;
//    @ExcelProperty(value = "其他资金")
    private String s14;
//    @ExcelProperty(value = "使用状况")
    private String s15;
//    @ExcelProperty(value = "使用方向")
    private String s16;
//    @ExcelProperty(value = "备注")
    private String s17;

}

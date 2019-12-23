package com.df.functional.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * create by hanyli 2019/12/3
 */
@Data
public class RptFormula {
    private String id;

    private String nd;

    private String rgCode;

    @ExcelProperty("所属报表编码")
    private String rptCode;

    private String rptName;

    private String fid;

    private String ftype;

    private String calcType;

    private String adtType;

    private Integer seqNo;

    private String adtMark;

    private String dwTypes;

    /**
     * 适应单位属性显示格式，需要将DW_CODE转换为DISP_CODE
     */
    private String dispDwTypes;

    @ExcelProperty("表达式")
    private String editExp;
    @ExcelProperty("公式位置")
    private String cellExp;

    private String isOk;

    private String isAuto;

    private String isAmong;

    private String isValid;

    private String compileErr;

    private String cellText;

    //我的公式需求添加  公式所属单位码
    @ExcelProperty("所属报表编码")
    private String isLocal;
}

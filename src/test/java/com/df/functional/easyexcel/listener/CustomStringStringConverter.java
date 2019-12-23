package com.df.functional.easyexcel.listener;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import org.apache.poi.ss.usermodel.DateUtil;

import java.util.Date;

/**
 * create by hanyli 2019/12/3
 */
public class CustomStringStringConverter implements Converter<Date> {

    @Override
    public Class supportJavaTypeKey() {
        return Date.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.NUMBER;
    }

    @Override
    public Date convertToJavaData(CellData cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {

            if (contentProperty == null || contentProperty.getDateTimeFormatProperty() == null) {
                return DateUtil.getJavaDate(cellData.getNumberValue().doubleValue(),
                        globalConfiguration.getUse1904windowing(), null);
            } else {
                return DateUtil.getJavaDate(cellData.getNumberValue().doubleValue(),
                        contentProperty.getDateTimeFormatProperty().getUse1904windowing(), null);
            }
    }

    @Override
    public CellData convertToExcelData(Date date, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return null;
    }
}

package com.df.functional.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class WaterAnalysisExcelDTO {


	@ExcelProperty(value = "样  本",index = 0)
	private String sample;

	@ExcelProperty(value = "采样时间")
	@DateTimeFormat("yyyy-MM-dd")
	private String samplingDate;

	@ExcelProperty(value = "(CaCO3)总硬度mg/L")
	@Value("${caCo3:0}")
	private BigDecimal caCo3;

	@ExcelProperty("毫克比(Ca+Mg)(K+Na)")
	@Value("${mgRate:0}")
	private BigDecimal mgRate;

	@ExcelProperty("PH")
	private String ph;

	@ExcelProperty("电导率\n" + "us/cm")
	private String electricalConductivity;

	@ExcelProperty("水质类型")
	private String waterQualityType;

	@ExcelProperty("阳离子K+mg/L")
	@Value("${mgKX:0}")
	private BigDecimal mgKX;

	@ExcelProperty("阳离子Na+mg/L")
	@Value("${mgNaX:0}")
	private BigDecimal mgNaX;

	@ExcelProperty("阳离子Ca2+mg/L")
	@Value("${mgCa2X:0}")
	private BigDecimal mgCa2X;

	@ExcelProperty("阳离子Mg2+mg/L")
	@Value("${mgMg2X:0}")
	private BigDecimal mgMg2X;

	@ExcelProperty("阳离子Femg/L")
	@Value("${mgFeX:0}")
	private BigDecimal mgFeX;

	@ExcelProperty("阴离子Cl-mg/L")
	@Value("${mgCiY:0}")
	private BigDecimal mgCiY;

	@ExcelProperty("阴离子HCO3-mg/L")
	@Value("${mgHco3Y:0}")
	private BigDecimal mgHco3Y;

	@ExcelProperty("阴离子CO32-mg/L")
	@Value("${mgCo32Y:0}")
	private BigDecimal mgCo32Y;

	@ExcelProperty("阴离子SO42-mg/L")
	@Value("${mgSo42Y:0}")
	private BigDecimal mgSo42Y;

	@ExcelProperty("阴离子NO3-mg/L")
	@Value("${mgNo3Y:0}")
	private BigDecimal mgNo3Y;

	@ExcelProperty(index = 5)
	@Value("${mMolKX:0}")
	private BigDecimal mmMolKX;

	@ExcelProperty("阳离子Na+mMol/L")
	@Value("${mMolNaX:0}")
	private BigDecimal mMolNaX;

	@ExcelProperty("阳离子Ca2+mMol/L")
	@Value("${mMolCa2X:0}")
	private BigDecimal mMolCa2X;

	@ExcelProperty("阳离子Mg2+mMol/L")
	@Value("${mMolMg2X:0}")
	private BigDecimal mMolMg2X;

	@ExcelProperty("阴离子Cl-mMol/L")
	@Value("${mMolCiY:0}")
	private BigDecimal mMolCiY;

	@ExcelProperty("阴离子HCO3-mMol/L")
	@Value("${mMolHco3Y:0}")
	private BigDecimal mMolHco3Y;

	@ExcelProperty("阴离子SO42-mMol/L")
	@Value("${mMolSo42Y:0}")
	private BigDecimal mMolSo42Y;

	@ExcelProperty("阴离子NO3-mMol/L")
	@Value("${mMolNo3Y:0}")
	private BigDecimal mMolNo3Y;

	public BigDecimal getmMolHco3Y() {
		return mMolHco3Y;
	}

	public void setmMolHco3Y(BigDecimal mMolHco3Y) {
		this.mMolHco3Y = mMolHco3Y;
	}

	public BigDecimal getMgNaX() {
		return mgNaX;
	}

	public void setMgNaX(BigDecimal mgNaX) {
		this.mgNaX = mgNaX;
	}
}

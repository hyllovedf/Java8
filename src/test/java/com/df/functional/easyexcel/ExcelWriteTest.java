package com.df.functional.easyexcel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.enums.WriteDirectionEnum;
import com.alibaba.excel.enums.WriteTypeEnum;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.read.metadata.ReadWorkbook;
import com.alibaba.excel.util.WorkBookUtil;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.merge.LoopMergeStrategy;
import com.alibaba.excel.write.merge.OnceAbsoluteMergeStrategy;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteWorkbook;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.row.SimpleRowHeightStyleStrategy;
import com.df.functional.easyexcel.entity.ComplexHeadWirte;
import com.df.functional.easyexcel.entity.DemoData;
import com.df.functional.easyexcel.entity.FillData;
import com.df.functional.easyexcel.entity.TemplateEntity;
import com.df.functional.easyexcel.handler.CustomHandler;
import com.df.functional.easyexcel.handler.MyHandler;
import com.df.functional.easyexcel.listener.TemplateListener;
import com.df.functional.util.ExcelUtil;
import org.apache.poi.ss.formula.functions.Complex;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.mockito.internal.junit.ExceptionFactory;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CompletableFuture;

/**
 * create by hanyli 2019/12/4
 */
public class ExcelWriteTest {
    private static List<DemoData> list = new ArrayList<>();
    private static List<ComplexHeadWirte> complexHeadWirteList = new ArrayList<>();
    private static List<FillData> fillDataList = new ArrayList<>();

    static {
//        String path = "C:\\Users\\Administrator\\Pictures\\Feedback\\{458BCFAD-6D6A-4170-9560-353B1B981FEE}\\Capture001.png";
        String path = "https://imgm.gmw.cn/attachement/jpg/site215/20200109/3670403329316376349.jpg";

        for (int i = 0; i < 10; i++) {
            list.add(new DemoData("hah;fh  ", new Date(), 89867.0, "ignore"));
            complexHeadWirteList.add(new ComplexHeadWirte("string: " + i, new Date(), 0.56));
            fillDataList.add(new FillData("df", i, 178));
        }
    }

    public static void main(String[] args) {
        String path = "https://imgm.gmw.cn/attachement/jpg/site215/20200109/3670403329316376349.jpg";
        File file = new File(path);
        simpleWrite();

    }

    public static void simpleWrite() {

        String filename = "simpleWrite-" + System.currentTimeMillis() + ".xlsx";
        String path = "C:\\Users\\Administrator\\Pictures\\Feedback\\{458BCFAD-6D6A-4170-9560-353B1B981FEE}\\Capture001.png";
        //设置needHead(false)可以不写入头
        long start = System.currentTimeMillis();
        EasyExcelFactory.write(filename, DemoData.class).sheet(1).useDefaultStyle(false).doWrite(list);
        System.out.println("时间" + (System.currentTimeMillis() - start) + "ms");
        /*ExcelWriter excelWriter = EasyExcelFactory.write(filename, DemoData.class).build();
        WriteSheet writeSheet = EasyExcelFactory.writerSheet("df").needHead(false).build();
        excelWriter.write(list, writeSheet);
        excelWriter.finish();*/
    }


    @Test
    public void excludeOrIncludeWrite() {
        String filename = "excludeOrIncludeWrite-" + System.currentTimeMillis() + ".xlsx";
        // 根据用户传入字段 假设我们要忽略 date 和注解@ExcelIgnore效果一样
        Set<String> excludeColumnFiledNames = new HashSet<String>();
        excludeColumnFiledNames.add("date");
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        /*EasyExcelFactory.write(filename, DemoData.class).excludeColumnFiledNames(excludeColumnFiledNames).sheet("模板")
                .doWrite(list);*/
        //只导出某一列
        EasyExcelFactory.write(filename, DemoData.class).includeColumnFiledNames(excludeColumnFiledNames).sheet("df").doWrite(list);
    }

    @Test
    public void complexHeadWirte() {
        String filename = "complexHeadWirte-" + System.currentTimeMillis() + ".xlsx";
        EasyExcelFactory.write(filename, ComplexHeadWirte.class).sheet("gg").doWrite(complexHeadWirteList);
    }

    @Test
    public void repeatedWrite() {
        String filename = "repeatedWrite-" + System.currentTimeMillis() + ".xlsx";
//        ExcelWriter excelWriter = EasyExcelFactory.write(filename, DemoData.class).build();

        //重复写入同一个sheet
        /*WriteSheet writeSheet = EasyExcelFactory.writerSheet("重复写入同一个sheet").build();
        for (int i = 0; i < 5; i++) {
            excelWriter.write(list, writeSheet);
        }*/

        //写入不同的页签
        /*for (int i = 0; i < 5; i++) {
            //必须指定sheetNo sheetName不能相同 不然所有数据只会写入一个sheet 和上面效果一样
            WriteSheet writeSheet = EasyExcelFactory.writerSheet( i,"写入不同的页签"+i).build();
            excelWriter.write(list, writeSheet);
        }*/
//        excelWriter.finish();
        ExcelWriter writer = EasyExcelFactory.write(filename).build();
        for (int i = 0; i < 2; i++) {
            WriteSheet writeSheet;
            if (i == 0) {
                writeSheet = EasyExcelFactory.writerSheet(i, "sheet" + i).head(DemoData.class).build();
            } else {
                writeSheet = EasyExcelFactory.writerSheet(i, "sheet" + i).head(ComplexHeadWirte.class).build();
            }
            writer.write(list, writeSheet);
        }
        writer.finish();

    }

    /**
     * 根据模板生成，结果是和模板的内容拼接
     */
    @Test
    public void templateWrite() {
        String templateName = "D:\\ideawork\\easyexcel-master\\src\\test\\resources\\demo\\demo.xlsx";
        String filename = "templateWrite-" + System.currentTimeMillis() + ".xlsx";
        EasyExcelFactory.read(templateName).sheet().doRead();

        ExcelWriter build = EasyExcelFactory.write(filename, DemoData.class)
                .withTemplate(templateName)
                .needHead(false).registerWriteHandler(new MyHandler()).build();
//        build.writeContext().writeWorkbookHolder().getWorkbook().removeSheetAt(1);
        for (int i = 0; i < 2; i++) {
            WriteSheet sheet = EasyExcelFactory.writerSheet(i).build();
            build.write(list, sheet);
        }

        build.finish();


//        Map<String, String> map = new HashMap<>();
//        for (int i = 2; i < 12; i++) {
//            map.put( i + ",3", "df");
//        }
//        map.put("name", "hyl");
//        EasyExcelFactory.write(filename).withTemplate(templateName).sheet().doFill(map);


    }

    @Test
    public void styleWrite() {
        String filename = "styleWrite-" + System.currentTimeMillis() + ".xlsx";
        //直接使用注解指定高度和宽度
        //其他使用WriteCellStyle这个类控制样式
        WriteCellStyle headCellStyle = new WriteCellStyle();
        //设置背景色
        headCellStyle.setFillBackgroundColor(IndexedColors.RED.getIndex());
        //字体的设置
        WriteFont headFont = new WriteFont();
        headFont.setBold(true);
        headFont.setFontHeightInPoints((short) 20);
        headCellStyle.setWriteFont(headFont);
        WriteCellStyle contentCellStyle = new WriteCellStyle();
        //这里需要指定 FillPatternType 为FillPatternType.SOLID_FOREGROUND 不然无法显示背景颜色.头默认了 FillPatternType所以可以不指定
        contentCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
        contentCellStyle.setFillForegroundColor(IndexedColors.GOLD.getIndex());
        //设置垂直对齐方式
        contentCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //水平对齐方式
        contentCellStyle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        //设置边框系列
        contentCellStyle.setBorderBottom(BorderStyle.MEDIUM);
        contentCellStyle.setBorderLeft(BorderStyle.THIN);
        contentCellStyle.setBorderRight(BorderStyle.THIN);
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headCellStyle, contentCellStyle);

        //设置行高  注意和注解一起使用时  以注解为准
        SimpleRowHeightStyleStrategy simpleRowHeightStyleStrategy = new SimpleRowHeightStyleStrategy((short) 70, (short) 50);

        OnceAbsoluteMergeStrategy onceAbsoluteMergeStrategy = new OnceAbsoluteMergeStrategy(1, 2, 1, 2);
        EasyExcelFactory.write(filename)
                .head(head())
                .registerWriteHandler(horizontalCellStyleStrategy)
                .registerWriteHandler(simpleRowHeightStyleStrategy)
//                .registerWriteHandler(onceAbsoluteMergeStrategy)
                .sheet(0).doWrite(list);
    }

    @Test
    public void mergeWrite() {
        String filename = "mergeWrite-" + System.currentTimeMillis() + ".xlsx";
        LoopMergeStrategy loopMergeStrategy = new LoopMergeStrategy(2, 2, 0);
        EasyExcelFactory.write(filename, DemoData.class).registerWriteHandler(loopMergeStrategy)
                .sheet().doWrite(list);

    }

    /**
     * 动态表头  可以用于表头合并的情形
     */
    @Test
    public void dynamicHeadWrite() {
        String filename = "dynamicHeadWrite-" + System.currentTimeMillis() + ".xlsx";
        EasyExcelFactory.write(filename)
                // 这里放入动态头
                .head(head()).sheet("模板")
                // 当然这里数据也可以用 List<List<String>> 去传入
                .doWrite(complexHeadWirteList);
    }

    private List<List<String>> head() {
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> head0 = new ArrayList<String>();
        head0.add("字符串" + System.currentTimeMillis());
//        head0.add("字符串" + System.currentTimeMillis());
        List<String> head1 = new ArrayList<String>();
        head1.add("数字" + System.currentTimeMillis());
//        head1.add("数字1" + System.currentTimeMillis());
        List<String> head2 = new ArrayList<String>();
        head2.add("日期" + System.currentTimeMillis());
//        head2.add("日期1" + System.currentTimeMillis());
        list.add(head0);
        list.add(head1);
        list.add(head2);
        return list;
    }

    @Test
    public void fillTest() {
        String templateName = "fillTemplate.xlsx";
        String filename = "fillTest-" + System.currentTimeMillis() + ".xlsx";
//        EasyExcelFactory.write(filename).withTemplate(templateName).sheet().doFill(fillDataList);
        ExcelWriter excelWriter = EasyExcelFactory.write(filename).withTemplate(templateName)
                .registerWriteHandler(new CustomHandler()).build();
        WriteSheet writeSheet = EasyExcelFactory.writerSheet().build();

        FillConfig fillConfig = FillConfig.builder().forceNewRow(true).build();
        Map<String, String> map = new HashMap<>();
        map.put("name", "list");
//        excelWriter.fill(map, writeSheet);
        excelWriter.fill(map,fillConfig, writeSheet);
//        excelWriter.fill(fillDataList,fillConfig, writeSheet);

        excelWriter.finish();
    }

    @Test
    public void fillHorizontalTest() {
        String templateName = "fillHorizontalTemplate.xlsx";
        String filename = "fillHorizontalTest-" + System.currentTimeMillis() + ".xlsx";
        ExcelWriter excelWriter = EasyExcelFactory.write(filename).withTemplate(templateName).build();
        WriteSheet writeSheet = EasyExcelFactory.writerSheet().build();
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        Map<String, String> map3 = new HashMap<>();
        map1.put("no", "1");
        map1.put("name", "zpc");
        map2.put("no", "2");
        map2.put("name", "lisi");
        map3.put("no", "3");
        map3.put("name", "furi");
        List<Map<String, String>> datas = new ArrayList<>();
        datas.add(map1);
        datas.add(map2);
        datas.add(map3);
        FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
        excelWriter.fill(datas, fillConfig, writeSheet);

//        excelWriter.fill(fillDataList, fillConfig, writeSheet);
        excelWriter.finish();
    }

    @Test
    public void writeTemplate() {
        long start = System.currentTimeMillis();
        String templateName = "template.xlsx";
        String filename = "template" + System.currentTimeMillis() + ".xlsx";
        TemplateListener templateListener = new TemplateListener();
        WriteCellStyle cellStyle = new WriteCellStyle();
        cellStyle.setWrapped(true);
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(null, cellStyle);
        EasyExcelFactory.write(filename).withTemplate(templateName)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .registerWriteHandler(new CustomHandler())
                .inMemory(true)
                .sheet().doWrite(list);


//        XSSFWorkbook workbook = new XSSFWorkbook(templateName);
//        XSSFSheet sheetAt = workbook.getSheetAt(0);
//        sheetAt.shiftRows(11,100,1);
//        XSSFRow row = sheetAt.createRow(11);
//        XSSFCell cell = row.createCell(1);
//        cell.setCellValue(90000);
//        workbook.write(new FileOutputStream(filename));
        System.out.println((System.currentTimeMillis() - start));
    }

}

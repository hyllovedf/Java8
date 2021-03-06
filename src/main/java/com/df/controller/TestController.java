package com.df.controller;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.df.entity.DemoData;
import com.df.service.TestService;
import com.df.starter.HelloService;
import org.ehcache.config.ResourceUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hanyli
 * @date 2020/1/7
 */
@RestController
public class TestController {
    private static List<DemoData> list = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            list.add(new DemoData("string: " + i, new Date(), 0.56, "ignore"));
        }
    }

    @Autowired
    private HelloService helloService;
    @Autowired
    private TestService testService;

    @GetMapping("starter")
    public String starter() {
        return helloService.say();
    }

    @GetMapping("test")
    public String test() {
        List<Map<String,Object>> query = testService.query();
        return "ok";
    }

    @GetMapping("download")
    public String download(HttpServletResponse response) throws Exception {
//        response.setContentType("application/vnd.ms-excel");
//        response.setCharacterEncoding("utf-8");
//        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
//        String fileName = URLEncoder.encode("测试", "UTF-8");
//        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
//        ExcelWriter writer = EasyExcelFactory.write(response.getOutputStream()).build();
//        for (int i = 0; i < 2; i++) {
//            WriteSheet writeSheet;
//            writeSheet = EasyExcelFactory.writerSheet(i, "sheet" + i).head(DemoData.class).build();
//            writer.write(list, writeSheet);
//        }
//        writer.finish();
        return "sf法法";
    }

    @PostMapping("upload")
    public String upload(MultipartFile file) {
        return file.getOriginalFilename();
    }
}

package com.df.demo;

import com.alibaba.excel.EasyExcelFactory;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.BuiltinFormats;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author hanyli
 * @date 2020/4/19
 */
public class Test {

    public static void main(String[] args) throws Exception {
        boolean noneEmpty = StringUtils.isNoneEmpty("df", " ",null);
        System.out.println(noneEmpty);
        Record record = getRecord("1");
        Record record2 = getRecord("1");
        System.out.println(record == record2);
    }

    private static Record getRecord(String s) {
        return null;
    }

    private static int getN(int k) {
        try {
            return 1;

        }finally {
            System.out.println("finally");
        }
    }

    public static void save(String fileId) {
        fileId = "dfdf";
    }
    static class MyThread implements Runnable {

        private int value;
        private Semaphore semaphore;

        public MyThread(int value, Semaphore semaphore) {
            this.value = value;
            this.semaphore = semaphore;
        }

        @SneakyThrows
        @Override
        public void run() {
            semaphore.acquire();
            System.out.println(String.format("当前线程%d,还有%d个资源,还有%d个线程等待",value,semaphore.availablePermits(),semaphore.getQueueLength()));
            Random random = new Random();
            Thread.sleep(random.nextInt(1000));
            semaphore.release();
            System.out.println(String.format("线程%d释放了资源",value));
        }
    }
}
